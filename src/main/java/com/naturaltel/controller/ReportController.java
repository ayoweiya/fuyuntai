package com.naturaltel.controller;
import com.google.gson.Gson;
import com.naturaltel.base.BaseController;
import com.naturaltel.model.SystemPropertiesModel;
import com.naturaltel.service.ReportService;
import com.naturaltel.support.ActionResult;
import com.naturaltel.util.ErrorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * judy on 2019/10/21
 */
@Controller
@RequestMapping("/report")
public class ReportController extends BaseController{
    @Autowired
    ReportService reportService;

    @Autowired
    public ReportController(SystemPropertiesModel properties, ReportService reportService) {
        super(properties);
        this.reportService = reportService;
    }

    @RequestMapping(value = "/itemClick")
    public String itemClick() {
        logger.info(defaultMethodInvokeLogFormat());
        ActionResult result = ActionResult.createSuccessResult();
        try {
            String sessionId = getSessionId();
            String channel = getStringParameter("channel").trim().isEmpty()?"fate":getStringParameter("channel");
            String msisdn = getStringParameter("msisdn");
            String loginType = getStringParameter("loginType");
            String userAccount = getStringParameter("userAccount");
            String userid = getStringParameter("userid");
            String pageId = getStringParameter("pageId");
            int itemType = getIntegerParameter("itemType");
            String itemId = getStringParameter("itemId");
            String operator = getStringParameter("operator");
            logger.info("sessionId=[{}], channel=[{}], msisdn=[{}], loginType=[{}], userAccount=[{}], userid=[{}], pageId=[{}], itemType=[{}]," +
                    " itemId=[{}], createTime=[{}], operator=[{}] ", sessionId, msisdn, loginType, userAccount, userid, pageId, itemType, itemId, operator);

            reportService.addItemClick(sessionId, channel, msisdn, loginType, userAccount, userid, pageId, itemType, itemId, operator);
        } catch (Exception e) {
            ErrorUtils.error(logger,e);
        }
        return new Gson().toJson(result);
    }

    @RequestMapping(value = "/pageView", produces = "application/json;charset=utf-8")
    public @ResponseBody String pageView() {
        logger.info(defaultMethodInvokeLogFormat());
        ActionResult result = ActionResult.createSuccessResult();
        try {
            String sessionId = getSessionId();
            String channel = getStringParameter("channel").trim().isEmpty()?"fate":getStringParameter("channel");
            String msisdn = getStringParameter("msisdn");
            String loginType = getStringParameter("loginType");
            String userAccount = getStringParameter("userAccount");
            String userid = getStringParameter("userid");
            String pageId = getStringParameter("pageId");
            String fromPageId = getSessionPage();
            String operator = getStringParameter("operator");
            reportService.addPageView(sessionId, channel, msisdn, loginType, userAccount, userid, pageId, fromPageId, operator);

            setSessionPage(pageId);
        } catch (Exception e) {
            logger.error(defaultMethodExceptionLogFormat(e));
        }
        return new Gson().toJson(result);
    }
}