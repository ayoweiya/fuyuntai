package com.naturaltel.controller;

import java.net.URLEncoder;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.naturaltel.base.BaseController;
import com.naturaltel.model.SystemPropertiesModel;
import com.naturaltel.service.HomeService;
import com.naturaltel.util.BouncyCastleAES;
import com.naturaltel.util.Secuity;
import com.naturaltel.util.network.HttpResponse;
import com.naturaltel.util.network.SendRequest;
import com.naturaltel.vo.LuckyProductVO;
import com.naturaltel.vo.api.DataVO;
import com.naturaltel.vo.api.LoginResultVO;
import com.naturaltel.vo.api.OpVO;
import com.naturaltel.vo.api.PaymentComResult;
import com.naturaltel.vo.db.FateHistoryVO;
import com.naturaltel.vo.db.TransIdPaymentComVO;
import com.naturaltel.vo.db.UserLampInfoVO;

@Controller
public class HomeController extends BaseController {
    @Value("${mainUrl}")
    String mainUrl;
    @Value("${channel}")
    String channelId;
    @Value("${cid}")
    String cid;

    @Value("${ssoLogin}")
    String ssoLogin;
    @Value("${checkLoginIdUrl}")
    String checkLoginIdUrl;
    @Value("${ssoAesKey}")
    String ssoAesKey;
    @Value("${ssoAesIv}")
    String ssoAesIv;

    @Value("${gameId}")
    String gameId;
    @Value("${aesKey}")
    String aesKey;
    @Value("${aesIv}")
    String aesIv;

    @Value("${amount_plan1}")
    Integer amount_plan1;
    @Value("${amount_plan2}")
    Integer amount_plan2;
    @Value("${amount_plan3-1}")
    Integer amount_plan3_1;
    @Value("${amount_plan3-2}")
    Integer amount_plan3_2;
    @Value("${amount_plan4-1}")
    Integer amount_plan4_1;
    @Value("${amount_plan4-2}")
    Integer amount_plan4_2;

    @Value("${votiveAmount1}")
    Integer votiveAmount1;
    @Value("${votiveAmount2}")
    Integer votiveAmount2;
    @Value("${votiveAmount3}")
    Integer votiveAmount3;

    @Autowired
    HomeService homeService;

    @Autowired
    public HomeController(SystemPropertiesModel properties) {
        super(properties);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Principal userDetails) {
        logger.info(defaultMethodInvokeLogFormat());

        return "redirect:/index.html";
    }

    @RequestMapping(value= "/phraphromLove", method = RequestMethod.GET)
    public String phraphromLove() { 
    	logger.info(defaultMethodInvokeLogFormat());
    	HttpSession session = getSession();
    	String channel = getStringParameter("channel");
    	logger.info("user come from : " + channel);
    	session.setAttribute("channel", channel);
    	
    	return "phraphromLove";
    }
    
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Principal userDetails) {
        logger.info(defaultMethodInvokeLogFormat());

        HttpSession session = getSession();
        String channel = getStringParameter("channel");
        logger.info("user come from : " + channel);
        session.setAttribute("channel", channel);
        // todo: session test
        //session.setAttribute("channel2", "HelpMe!!!!!");

        return "index";
    }

    // 導payment
    @RequestMapping(value = "/goPaymentCom", method = RequestMethod.GET)
    public String goPaymentCom(Principal userDetails) {
        logger.info(defaultMethodInvokeLogFormat());
        HttpSession session = getSession();

        // todo: session test
        //logger.warn("session channel2: " + session.getAttribute("channel2"));

        // 購買方案
        String buyType = getStringParameter("buyType");
        if ("".equals(buyType)) {
            return redirectToLink(mainUrl + "/fuyuntai/payFail.html");
        }

        // 價格
        int amount = 0;
        // 優惠券
        String commodityId = "";
        logger.debug("buyType:{}", buyType);
        switch (buyType) {
            case "plan_1":
                amount = amount_plan1;
                commodityId = "20220003";
                break;
//            case "plan_2":
//                amount = amount_plan2;
//                commodityId = "20190015";
//                break;
//            case "plan_3-1":
//                amount = amount_plan3_1;
//                commodityId = "20190017";
//                break;
//            case "plan_3-2":
//                amount = amount_plan3_2;
//                commodityId = "20190016";
//                break;
//            case "plan_4-1":
//                amount = amount_plan4_1;
//                commodityId = "20190019";
//                break;
//            case "plan_4-2":
//                amount = amount_plan4_2;
//                commodityId = "20190018";
//                break;
            default:
        }
        logger.debug("amount:{}, commodityId:{}",amount, commodityId);

        String country = getStringParameter("cCode");
        String phone = getStringParameter("userPhone");
        if ("886".equals(country)) {
            // 如手機號碼不為10碼及開頭不為0時
            if (phone.length() != 10 && !phone.startsWith("0")) {
                phone = "0" + phone;
            }
        }
        String uid = country + phone;
        logger.info("uid = " + uid);

        // 導到payment頁面
        DataVO data = new DataVO();

        // 生成訂單號
        String orderId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime()) + String.format("%05d", homeService.getNextVal("fuyuntaiOrderId"));
        String ip = getRemoteIP();

        data.setOrderId(orderId);
        data.setUid(uid);
        data.setUserIp(ip);
        data.setCountryPrefix(country);
        data.setMsisdn(phone);
        data.setChannel((String) session.getAttribute("channel"));
        data.setCommodityId(commodityId);
        data.setAmount(amount);
        data.setBuyUsage(1);
        data.setUseUsage(1);
        String memo = uid + "@@" + buyType;
        data.setMemo(memo);

        data.setCallBackUrl(mainUrl + "/fuyuntai/updateOrderStatus"); // 更新用
        data.setBackUrl(mainUrl + "/fuyuntai/paySuccessAndInfo.html?fateOrder=" + orderId);

        // 獲取txid
        PaymentComResult paymentResult = homeService.getTxIdResult(cid, data, ip);
        String txId = paymentResult.getTxId();
        data.setTxId(txId);
        logger.info(data);

        TransIdPaymentComVO vo = new TransIdPaymentComVO();

        vo.setOrderId(orderId);
        vo.setTxid(txId);
        vo.setSessionId(getSessionId());
        vo.setUserip(ip);
        vo.setUid(uid);
        vo.setCountryPrefix(country);
        vo.setMsisdn(phone);
        vo.setChannel((String) session.getAttribute("channel"));
        vo.setCommodityId(commodityId);
        vo.setAmount(amount);
        vo.setBuyUsage(1);
        vo.setUseUsage(1);
        vo.setMemo(memo);
        vo.setRequestResultCode(paymentResult.getResultCode());
        vo.setRequestResultMsg(paymentResult.getResultMsg());

        homeService.insertOrder(vo);

        return redirectToLink(homeService.useUsageUrl(txId, data));
    }

    // 承接快樂包
    // 會從home導來
    @RequestMapping(value = "/goKeepUserInfo", method = RequestMethod.GET)
    public String goKeepInfo(Principal userDetails, Model model) {
        logger.info(defaultMethodInvokeLogFormat());
        HttpSession session = getSession();

        String encryptMsisdn = getStringParameter("msisdn");
        String msisdn = Secuity.decrypt(encryptMsisdn);
        msisdn = msisdn.startsWith("09") ? "886" + msisdn : msisdn;

        session.setAttribute("userMsisdn", msisdn);
        logger.info(redirectToLink(mainUrl + "/fuyuntai/orderList.html"));
        return redirectToLink(mainUrl + "/fuyuntai/orderList.html");
    }

    @RequestMapping(value = "/insertFateHistory")
    @ResponseBody
    public void insertFateHistory() {

        logger.info("呼叫API增加一筆訂單!");

        try {
            String data = getStringParameter("data");
            logger.info("data: " + data);

            // URL不需要再decode，因為瀏覽器已經decode URL了!!!!!不然+會被吃掉!!!!!
            //String urldecode = URLDecoder.decode(data, "UTF-8");
            //logger.info("urlDecode: " + urldecode);

            String dataStr = BouncyCastleAES.decrypt(aesKey, aesIv, data);
            logger.info("dataStr: " + dataStr);

            JsonObject obj = new Gson().fromJson(dataStr, JsonObject.class);
            logger.info("obj: " + obj);

            // msisdn
            String msisdn = Secuity.decrypt(obj.get("msisdn").getAsString());
            logger.info("msisdn in the dataStr: " + msisdn);
            String lampType = obj.get("lampType").getAsString();
            logger.info("lampType in the dataStr: " + lampType);
            msisdn = msisdn.startsWith("09") ? "886" + msisdn : msisdn;

            // lampTypeName
            // 現在快樂包有6種:
            // fate_light, fate_light_and_product, fate_safe, fate_flower_6M, fate_job_6M,
            // fate_flower_6M_combination + fate_job_6M_combination (C是連在一起的!)
            String lampTypeName = "";
            switch (lampType) {
                case "fate_light":
                    lampTypeName = "plan_1";
                    break;
                case "fate_job_6M_and_product":
                    lampTypeName = "light_fate_product";
                    break;
                case "fate_safe":
                    lampTypeName = "plan_2";
                    break;
                case "fate_flower_6M":
                    lampTypeName = "plan_4-1";
                    break;
                case "fate_flower_6M_combination": // 會和 money6C 連在一起
                    lampTypeName = "plan_4-1";
                    break;
                case "fate_job_6M":
                    lampTypeName = "plan_3-1";
                    break;
                case "fate_job_6M_combination": // 會和 love6C 連在一起
                    lampTypeName = "plan_3-1";
                    break;
                default:
            }

            String orderId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime()) + String.format("%05d", homeService.getNextVal("fuyuntaiOrderId")) + "_gtHappy";
            homeService.insertHistory(orderId, msisdn, lampTypeName);
        } catch (Exception e) {
            logger.error("", e);
        }


    }

    // 購買成功&填寫資料頁
    @RequestMapping(value = "/paySuccessAndInfo", method = RequestMethod.GET)
    public String paySuccessAndInfo(Principal userDetails, Model model) {
        logger.info(defaultMethodInvokeLogFormat());
        // 確認購買門號 + 燈
        String fateOrder = getStringParameter("fateOrder");
        FateHistoryVO fateHistory = null;
        if (!"".equals(fateOrder)) {
            // 獲得此訂單紀錄
            fateHistory = homeService.getFateHistoryByOrderId(fateOrder);
            logger.info(fateHistory);
        } else {
            return redirectToLink(mainUrl + "/fuyuntai/payFail.html");
        }

        // 此筆訂單是否填寫完成
        // 如果已經填完了，會出現(不可調的)付費成功頁paySuccess.jsp
        if (fateHistory.getHasLampInfo() == 1) {
            UserLampInfoVO userLampInfo = homeService.getUserInfoVotive(fateOrder);

            model.addAttribute("name", userLampInfo.getName());
            String birthDay = userLampInfo.getBirthDay();
            String birthYear = birthDay.substring(0, 4);
            String birthMonth = birthDay.substring(4, 6);
            String birthDate = birthDay.substring(6);
            model.addAttribute("birthYear", birthYear);
            model.addAttribute("birthMonth", Integer.valueOf(birthMonth));
            model.addAttribute("birthDate", Integer.valueOf(birthDate));
            model.addAttribute("area", userLampInfo.getArea());
            model.addAttribute("city", userLampInfo.getCity());
            model.addAttribute("dist", userLampInfo.getDist());
            model.addAttribute("road", userLampInfo.getRoad());
            model.addAttribute("wishMsg", userLampInfo.getWishMsg());

            model.addAttribute("name_luckyProduct", userLampInfo.getName_luckyProduct());
            model.addAttribute("area_luckyProduct", userLampInfo.getArea_luckyProduct());
            model.addAttribute("city_luckyProduct", userLampInfo.getCity_luckyProduct());
            model.addAttribute("dist_luckyProduct", userLampInfo.getDist_luckyProduct());
            model.addAttribute("road_luckyProduct", userLampInfo.getRoad_luckyProduct());
        }

        // 此訂單還沒有填寫完成
        String lampType = fateHistory.getLampType();
        List<String> lampTypeNameList = new ArrayList<>();
        String lampTypeName = "";
        String luckyProduct = "none";

        logger.info("lampType: " + lampType);
        switch (lampType) {
            case "plan_1":
                lampTypeName = "光明燈";
                break;
            case "light_fate_product":
                lampTypeName = "四面佛-事業招財燈";
                luckyProduct = "開運商品";
                break;
            case "plan_2":
                lampTypeName = "安太歲";
                break;
            case "plan_3-1":
                lampTypeName = "四面佛-事業招財燈(6個月)";
                break;
            case "plan_3-2":
                lampTypeName = "四面佛-事業招財燈(3個月)";
                break;
            case "plan_4-1":
                lampTypeName = "四面佛-愛神燈(6個月)";
                break;
            case "plan_4-2":
                lampTypeName = "四面佛-愛神燈(3個月)";
                break;
            default:
        }
        logger.info("lampTypeName: " + lampTypeName);

        model.addAttribute("fateOrder", fateHistory.getFateOrder());
        model.addAttribute("userMsisdn", fateHistory.getMsisdn());
        model.addAttribute("lampTypeName", lampTypeName);
        model.addAttribute("luckyProduct", luckyProduct);

        return "Common/paySuccess";  // 付費成功頁(可調或不可調)
    }

    // 購買失敗
    @RequestMapping(value = "/payFail", method = RequestMethod.GET)
    public String payFail(Principal userDetails, Model model) {
        logger.info(defaultMethodInvokeLogFormat());

        return "Common/fail";
    }

    // 填寫資料頁前端導來
    // 記錄個人資訊
    @RequestMapping(value = "/saveInfo", method = RequestMethod.GET)
    public String saveInfo(Principal userDetails, Model model) {
        logger.info(defaultMethodInvokeLogFormat());
        HttpSession session = getSession();

        UserLampInfoVO userLampInfoVO = new UserLampInfoVO();

        String fateOrder = getStringParameter("fateOrder");
        String userMsisdn = getStringParameter("userMsisdn");
        session.setAttribute("userMsisdn", userMsisdn);
        userLampInfoVO.setFateOrder(fateOrder);
        userLampInfoVO.setMsisdn(userMsisdn);

        String name = getStringParameter("name");
        userLampInfoVO.setName(name);

        String birthYear = getStringParameter("birth-year");
        String birthMonth = getStringParameter("birth-month");
        if (birthMonth.length() <= 1) {
            birthMonth = "0" + birthMonth;
        }
        String birthDate = getStringParameter("birth-day");
        if (birthDate.length() <= 1) {
            birthDate = "0" + birthDate;
        }
        String birth = birthYear + birthMonth + birthDate;
        userLampInfoVO.setBirthDay(birth);

        String area = getStringParameter("area");
        String city = getStringParameter("city");
        String dist = getStringParameter("dist");
        String road = getStringParameter("road");
        userLampInfoVO.setArea(area);
        userLampInfoVO.setCity(city);
        userLampInfoVO.setDist(dist);
        userLampInfoVO.setRoad(road);

        String wishMsg = getStringParameter("wish-msg");
        userLampInfoVO.setWishMsg(wishMsg);

        // 開運商品
        String name_luckyProduct = getStringParameter("name_luckyProduct");
        userLampInfoVO.setName_luckyProduct(name_luckyProduct);

        String area_luckyProduct = getStringParameter("area_luckyProduct");
        String city_luckyProduct = getStringParameter("city_luckyProduct");
        String dist_luckyProduct = getStringParameter("dist_luckyProduct");
        String road_luckyProduct = getStringParameter("road_luckyProduct");
        userLampInfoVO.setArea_luckyProduct(area_luckyProduct);
        userLampInfoVO.setCity_luckyProduct(city_luckyProduct);
        userLampInfoVO.setDist_luckyProduct(dist_luckyProduct);
        userLampInfoVO.setRoad_luckyProduct(road_luckyProduct);

        logger.info("userLampInfoVO: " + userLampInfoVO);

        homeService.insertUserLampInfo(userLampInfoVO);
        homeService.updateHistoryLampInfo(fateOrder, userMsisdn); // set lampInfo == 1, lampInfo default == 0

        // (views)到訂單頁
        return redirectToLink(mainUrl + "/fuyuntai/orderList.html");
    }

    // (views)訂單頁
    @RequestMapping(value = "/orderList", method = RequestMethod.GET)
    public String orderList(Principal userDetails, Model model) {
        logger.info(defaultMethodInvokeLogFormat());
        HttpSession session = getSession();

        // (1) 有 msisdn, saveInfo來的
        String msisdn = (String) session.getAttribute("userMsisdn");
        // (2) 無 msisdn, SSO確認門號
        if (msisdn == null) {
            String returnUrl = mainUrl + "/fuyuntai/ssoConfirm.html";
            String opStr = "";
            opStr = goSSOLogin(new Gson(), new OpVO(), returnUrl, ssoAesKey, ssoAesIv);

            logger.info(opStr);
            try {
                opStr = URLEncoder.encode(opStr, "UTF-8");
            } catch (Exception e) {
                logger.info(e);
            }
            logger.info(opStr);
            // 用SSO登入
            return "redirect:" + ssoLogin + "?gameId=" + gameId + "&op=" + opStr;
        }

        // 取得此門號訂單
        logger.info(msisdn);
        List<FateHistoryVO> orderList = homeService.getFateOrderListByMsisdn(msisdn);
        List<LuckyProductVO> LuckyProductVO_List = new ArrayList<>();
        for (FateHistoryVO order : orderList) {
            String lampType = order.getLampType();
            String lampTypeName = "";
            String luckyProduct = "";

            switch (lampType) {
                case "plan_1":
                    lampTypeName = "光明燈";
                    break;
                case "light_fate_product":
                    lampTypeName = "四面佛-事業招財燈";
                    LuckyProductVO detail = new LuckyProductVO();
                    detail.setIdx(order.getIdx());
                    detail.setHasLampInfo(order.getHasLampInfo());
                    detail.setFateOrder(order.getFateOrder());
                    detail.setCreateTime(new SimpleDateFormat("yyyy/MM/dd").format(order.getCreateTime()));
                    detail.setDeliver_Way_LuckyProduct(order.getDeliver_Way_LuckyProduct());
                    detail.setDeliver_ID_LuckyProduct(order.getDeliver_ID_LuckyProduct());
                    detail.setDeliver_Time_LuckyProduct(order.getDeliver_Time_LuckyProduct());

                    LuckyProductVO_List.add(detail);
                    break;
                case "plan_2":
                    lampTypeName = "安太歲";
                    break;
                case "plan_3-1":
                    lampTypeName = "四面佛-事業招財燈(6個月)";
                    break;
                case "plan_3-2":
                    lampTypeName = "四面佛-事業招財燈(3個月)";
                    break;
                case "plan_4-1":
                    lampTypeName = "四面佛-愛神燈(6個月)";
                    break;
                case "plan_4-2":
                    lampTypeName = "四面佛-愛神燈(3個月)";
                    break;
                default:
            }
            order.setLampType(lampTypeName);

            // 購買時間
            Timestamp buyTime = order.getCreateTime();
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            order.setBuyTime(sdf.format(buyTime));

            // 還願時間
            Timestamp votiveTime = order.getVotiveTime();
            String votiveTimes = votiveTime == null ? "" : sdf.format(votiveTime);
            order.setVotiveTimes(votiveTimes);

            String votiveType = order.getVotiveType();
            if (votiveType != null) {
                String votiveTypeName = "";

                switch (votiveType) {
                    case "threeMonth":
                        votiveTypeName = "供象3個月";
                        break;
                    case "halfYear":
                        votiveTypeName = "供象6個月";
                        break;
                    case "oneYear":
                        votiveTypeName = "供象12個月";
                        break;
                    default:
                }

                order.setVotiveType(votiveTypeName);
            }
        }

        model.addAttribute("orderList", orderList);
        model.addAttribute("LuckyProductVO_List", LuckyProductVO_List);
        model.addAttribute("pathUrl", mainUrl.replace("fate", "api"));

        return "Common/orderDetail";
    }

    // 導payment
    @RequestMapping(value = "/goVotive", method = RequestMethod.GET)
    public String goVotive(Principal userDetails) {
        logger.info(defaultMethodInvokeLogFormat());
        HttpSession session = getSession();

        // 還願方案
        String votiveType = getStringParameter("votiveType");
        String msisdn = (String) session.getAttribute("userMsisdn");
        if ("".equals(votiveType) || msisdn == null) {
            return redirectToLink(mainUrl + "/fuyuntai/payFail.html");
        }

        // 價格
        int amount = 0;
        // 優惠券
        String commodityId = "";
        switch (votiveType) {
            case "threeMonth":
                amount = votiveAmount1;
                commodityId = "20190020";
                break;
            case "halfYear":
                amount = votiveAmount2;
                commodityId = "20190021";
                break;
            case "oneYear":
                amount = votiveAmount3;
                commodityId = "20190022";
                break;
            default:
        }

        String uid = msisdn;
        logger.info("uid = " + uid);

        String country = msisdn.startsWith("886") ? msisdn.substring(0, 3) : "";
        String phone = msisdn.startsWith("886") ? msisdn.substring(3) : msisdn;

        // 導到payment頁面
        DataVO data = new DataVO();

        // 生成訂單號
        String orderId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime()) + String.format("%05d", homeService.getNextVal("fuyuntaiOrderId"));
        String ip = getRemoteIP();

        data.setOrderId(orderId);
        data.setUid(uid);
        data.setUserIp(ip);
        data.setCountryPrefix(country);
        data.setMsisdn(phone);
        data.setChannel((String) session.getAttribute("channel"));
        data.setCommodityId(commodityId);
        data.setAmount(amount);
        data.setBuyUsage(1);
        data.setUseUsage(1);
        String fateOrder = getStringParameter("fateOrder");
        String memo = uid + "@@" + votiveType + "@@" + fateOrder;
        data.setMemo(memo);

        data.setCallBackUrl(mainUrl + "/fuyuntai/updateVotiveOrder"); // 更新用
        data.setBackUrl(mainUrl + "/fuyuntai/orderList.html");

        // 獲取txid
        PaymentComResult paymentResult = homeService.getTxIdResult(cid, data, ip);
        String txId = paymentResult.getTxId();
        data.setTxId(txId);
        logger.info(data);

        TransIdPaymentComVO vo = new TransIdPaymentComVO();

        vo.setOrderId(orderId);
        vo.setTxid(txId);
        vo.setSessionId(getSessionId());
        vo.setUserip(ip);
        vo.setUid(uid);
        vo.setCountryPrefix(country);
        vo.setMsisdn(phone);
        vo.setChannel((String) session.getAttribute("channel"));
        vo.setCommodityId(commodityId);
        vo.setAmount(amount);
        vo.setBuyUsage(1);
        vo.setUseUsage(1);
        vo.setMemo(memo);
        vo.setRequestResultCode(paymentResult.getResultCode());
        vo.setRequestResultMsg(paymentResult.getResultMsg());

        homeService.insertOrder(vo);

        return redirectToLink(homeService.useUsageUrl(txId, data));
    }

    @RequestMapping(value = "/ssoConfirm", method = RequestMethod.GET)
    public String ssoConfirm(Principal userDetails) {
        logger.info(defaultMethodInvokeLogFormat());
        Gson gson = new Gson();
        OpVO op = new OpVO();
        HttpSession session = getSession();

        String result = getStringParameter("aa-result");
        String msg = getStringParameter("aa-message");
        String returnOp = getStringParameter("op");

        String returnUrl = mainUrl + "/fuyuntai/orderList.html";
        if ("0000".equals(result) && "OK".equalsIgnoreCase(msg)) {
            logger.info(returnOp);

            String opStr = BouncyCastleAES.decrypt(ssoAesKey, ssoAesIv, returnOp);
            logger.info("decrypt = " + opStr);

            op = gson.fromJson(opStr, OpVO.class);
            logger.info(op);

            String countryPrefix = "";
            String phoneNum = "";
            if (op != null && op.getLoginId() != null) {
                HttpResponse httpResp = null;
                try {
                    httpResp = SendRequest.sendHTTPRequest(checkLoginIdUrl, "POST", "loginId=" + op.getLoginId(),
                            3000, true, logger, 3000);
                } catch (Exception e) {
                    logger.info(e);
                }
                String respStr = httpResp == null ? "" : httpResp.toString();

                LoginResultVO loginResult = new Gson().fromJson(respStr, LoginResultVO.class);
                logger.info("loginResult = " + loginResult);

                // 成功取得門號
                if (loginResult != null && "0000".equalsIgnoreCase(loginResult.getResult())) {
                    if (loginResult.getLoginId().equalsIgnoreCase(op.getLoginId())) {
                        // 取得門號
                        String account = op.getAccount();
                        logger.info(account);

                        if (account.startsWith("886")) {
                            countryPrefix = account.substring(0, 3);
                            phoneNum = "0" + account.substring(3);
                        } else if (account.startsWith("852") ||
                                account.startsWith("853")) {
                            countryPrefix = account.substring(0, 3);
                            phoneNum = account.substring(3);
                        } else if (account.startsWith("60") ||
                                account.startsWith("65") ||
                                account.startsWith("86")) {
                            countryPrefix = account.substring(0, 2);
                            phoneNum = account.substring(2);
                        }

                        logger.info(countryPrefix);
                        logger.info(phoneNum);
                    }
                }
            }
            session.setAttribute("userMsisdn", countryPrefix + phoneNum);
        }
        return redirectToLink(returnUrl);
    }

    @RequestMapping(value = "/updateOrderStatus", produces = "application/json;charset=utf-8")
    public @ResponseBody
    String updateOrderStatus() {
        logger.info(defaultMethodInvokeLogFormat());
        String returnStr = "";
        try {
            homeService.insertApiLog("updateOrderStatus", defaultMethodInvokeLogFormat(), "receive", getRemoteIP());

            Gson gson = new Gson();
            String updateCid = getStringParameter("cid");
            String dataStr = getStringParameter("Data");

            DataVO data = homeService.decryptDataVO(updateCid, dataStr);
            logger.info(data);
            if (data != null) {
                TransIdPaymentComVO vo = new TransIdPaymentComVO();

                vo.setCallBackResultCode(data.getResultCode());
                vo.setCallBackResultMsg(data.getResultMsg());
                vo.setOrderId(data.getOrderId());
                vo.setTxid(data.getTxId());
                vo.setPayTime(data.getPayTime());
                vo.setUid(data.getUid());
                vo.setCommodityId(data.getCommodityId());
                vo.setRealAmount(data.getAmount());
                vo.setRealUseUsage(data.getUseUsage());
                String memo = data.getMemo();
                vo.setMemo(memo);

                logger.info(vo);
                homeService.updateOrder(vo);

                logger.info(data.getResultCode());
                if ("0000".equals(data.getResultCode())) {
                    logger.info(memo);
                    String[] updateInfos = memo.split("@@");
                    homeService.insertHistory(data.getOrderId(), updateInfos[0], updateInfos[1]);
                }

                DataVO returnData = new DataVO();
                returnData.setResultCode("0000");
                returnData.setResultMsg("更新成功");

                returnStr = gson.toJson(returnData);
            }
        } catch (Exception e) {
            logger.error(defaultMethodExceptionLogFormat(e));
        }
        return returnStr;
    }

    @RequestMapping(value = "/updateVotiveOrder", produces = "application/json;charset=utf-8")
    public @ResponseBody
    String updateVotiveOrder() {
        logger.info(defaultMethodInvokeLogFormat());
        String returnStr = "";
        try {
            homeService.insertApiLog("updateVotiveOrder", defaultMethodInvokeLogFormat(), "receive", getRemoteIP());

            Gson gson = new Gson();
            String updateCid = getStringParameter("cid");
            String dataStr = getStringParameter("Data");

            DataVO data = homeService.decryptDataVO(updateCid, dataStr);
            logger.info(data);
            if (data != null) {
                TransIdPaymentComVO vo = new TransIdPaymentComVO();

                vo.setCallBackResultCode(data.getResultCode());
                vo.setCallBackResultMsg(data.getResultMsg());
                vo.setOrderId(data.getOrderId());
                vo.setTxid(data.getTxId());
                vo.setPayTime(data.getPayTime());
                vo.setUid(data.getUid());
                vo.setCommodityId(data.getCommodityId());
                vo.setRealAmount(data.getAmount());
                vo.setRealUseUsage(data.getUseUsage());
                String memo = data.getMemo();
                vo.setMemo(memo);

                logger.info(vo);
                homeService.updateOrder(vo);

                logger.info(data.getResultCode());
                if ("0000".equals(data.getResultCode())) {
                    logger.info(memo);
                    String[] updateInfos = memo.split("@@");

                    // 更新訂單狀態
                    homeService.updateHistoryLampInfoVotive(updateInfos[2], updateInfos[0], updateInfos[1]);
                }

                DataVO returnData = new DataVO();
                returnData.setResultCode("0000");
                returnData.setResultMsg("更新成功");

                returnStr = gson.toJson(returnData);
            }
        } catch (Exception e) {
            logger.error(defaultMethodExceptionLogFormat(e));
        }
        return returnStr;
    }

    private String goSSOLogin(Gson gson, OpVO op, String returnUrl, String aesKey, String aesIv) {
        op.setSessionId(getSessionId());
        op.setUrl(returnUrl);
        logger.info(returnUrl);

        op.setMode("4");
        op.setOtp("0");
        op.setTime(new SimpleDateFormat("YYYYMMDDhhmmss").format(new Date()));
        op.setData("orderLamp");
        op.setChannel(channelId);

        logger.info("aesKey = " + aesKey + ", aesIv = " + aesIv);

        String opVoStr = gson.toJson(op);
        String opStr = "";

        try {
            opStr = BouncyCastleAES.encrypt(aesKey, aesIv, opVoStr);
        } catch (Exception e) {
            logger.error(defaultMethodExceptionLogFormat(e));
        }
        return opStr;
    }

    // todo: test
//    @RequestMapping(value = "/Common/{url}", method = RequestMethod.GET)
//    public String Common(@PathVariable String url) {
//        return "Common/" + url;
//    }


}