package com.naturaltel.service.impl;

import com.google.gson.Gson;
import com.naturaltel.dao.ApiLogDAO;
import com.naturaltel.dao.FateHistoryDAO;
import com.naturaltel.dao.SequenceDAO;
import com.naturaltel.dao.TransIdPaymentComDAO;
import com.naturaltel.dao.UserLampInfoDAO;
import com.naturaltel.dao.ViewProjectDAO;
import com.naturaltel.service.HomeService;
import com.naturaltel.util.BouncyCastleAES;
import com.naturaltel.util.network.NetworkUtil;
import com.naturaltel.vo.api.DataVO;
import com.naturaltel.vo.api.PaymentComResult;
import com.naturaltel.vo.db.FateHistoryVO;
import com.naturaltel.vo.db.TransIdPaymentComVO;
import com.naturaltel.vo.db.UserLampInfoVO;
import com.naturaltel.vo.db.ViewProjectVO;

import java.net.URLEncoder;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    private final Logger logger = LogManager.getLogger(getClass());

    @Value("${paymentUrl}")
    String paymentUrl;
    @Value("${aesKey}")
    String aesKey;
    @Value("${aesIv}")
    String aesIv;
    
    @Autowired
    private final ApiLogDAO apiLogDAO;
    @Autowired
    private final TransIdPaymentComDAO transIdPaymentComDAO;
    @Autowired
    private final SequenceDAO sequenceDAO;
    @Autowired
    private final ViewProjectDAO viewProjectDAO;
    @Autowired
    private final FateHistoryDAO fateHistoryDAO;
    @Autowired
    private final UserLampInfoDAO userLampInfoDAO;
    
    public HomeServiceImpl(ApiLogDAO apiLogDAO, TransIdPaymentComDAO transIdPaymentComDAO
    		, SequenceDAO sequenceDAO, ViewProjectDAO viewProjectDAO
    		, FateHistoryDAO fateHistoryDAO, UserLampInfoDAO userLampInfoDAO) {
    	this.apiLogDAO = apiLogDAO;
    	this.transIdPaymentComDAO = transIdPaymentComDAO;
    	this.sequenceDAO = sequenceDAO;
    	this.viewProjectDAO = viewProjectDAO;
    	this.fateHistoryDAO = fateHistoryDAO;
    	this.userLampInfoDAO = userLampInfoDAO;
    }
    
    @Override
	public void insertApiLog(String method, String param, String type, String ip) {
    	apiLogDAO.insert(method, param, type, ip);
    }
    
    @Override    
    public int getNextVal(String sequenceName) {
    	return sequenceDAO.getNextVal(sequenceName);
    }
    
    @Override
	public PaymentComResult getTxIdResult(String cid, DataVO dataVO, String ip) {  
    	String url = "";
    	
    	Gson gson = new Gson();
    	String dataStr = "";
    	PaymentComResult getResult = null;
		try {
			dataStr = BouncyCastleAES.encrypt(aesKey, aesIv, gson.toJson(dataVO));
			apiLogDAO.insert("getTxIdResult", dataStr, "send", ip);
			
	    	String data = URLEncoder.encode(dataStr);
	    	
	    	url = paymentUrl + "/getTxId?"
	    			+ "cid=" + cid
	    			+ "&data=" + data;
	    	
	    	String jsonResult = NetworkUtil.http(url);
            logger.info(jsonResult);
            
            getResult = gson.fromJson(jsonResult, PaymentComResult.class);            
            logger.info("getResult-->" + getResult);
            
            if (getResult == null || !"0000".equals(getResult.getResultCode())) {
            	return getResult;
            }
		} catch (Exception e) {
			logger.info(e);
		}
		return getResult;
    }
    
    @Override
    public String useUsageUrl(String txId, DataVO dataVO){
    	String url = "";
    	
    	Gson gson = new Gson();
    	String dataStr = "";
		try {
			dataStr = BouncyCastleAES.encrypt(aesKey, aesIv, gson.toJson(dataVO));
			
			if ("".equals(dataStr)) {
				return url;
			}
	    	String data = URLEncoder.encode(dataStr);
	    	
	    	url = paymentUrl + "/useUsage?"
	    			+ "txId=" + txId
	    			+ "&data=" + data;
	    	
	    	logger.info(url);
		} catch (Exception e) {
			logger.info(e);
		}
		
    	return url;
    }
    
    @Override
    public void insertOrder(TransIdPaymentComVO vo) {
    	transIdPaymentComDAO.insert(vo);
    }
    
    @Override
    public DataVO decryptDataVO(String cid, String dataStr) {
    	DataVO data = null;
    	
    	Gson gson = new Gson();    	
    	String dataJson = BouncyCastleAES.decrypt(aesKey, aesIv, dataStr);
    	logger.info(dataJson);    	
    	data = gson.fromJson(dataJson, DataVO.class);
    	
    	return data;    	
    }
    
    @Override
	public void updateOrder(TransIdPaymentComVO vo) {
    	transIdPaymentComDAO.update(vo);
    }
	
    @Override
	public String getMemoByOrderId(String orderid) {
    	return transIdPaymentComDAO.getMemoByOrderId(orderid);
    }
	
    @Override
	public ViewProjectVO getProjectByIdx(String idx) {
    	return viewProjectDAO.getProjectByIdx(idx);
    }
    
    @Override
    public int insertHistory(String fateOrder, String msisdn, String lampType) {
    	return fateHistoryDAO.insert(fateOrder, msisdn, lampType);
    }
    
    @Override
    public FateHistoryVO getFateHistoryByOrderId(String fateOrder) {
    	return fateHistoryDAO.getFateHistoryVO(fateOrder);
    }
    
    @Override
    public List<FateHistoryVO> getFateHistoryByMsisdnAndType(String msisdn, String lampType) {
        return fateHistoryDAO.getFateHistoryVO(msisdn, lampType);
    }
    
    @Override
    public int updateHistoryLampInfo(String fateOrder, String msisdn) {
    	return fateHistoryDAO.update(fateOrder, msisdn);
    }
    
    @Override
    public void insertUserLampInfo(UserLampInfoVO userLampInfoVO) {
    	userLampInfoDAO.insertUserLampInfo(userLampInfoVO);
    }
    
    @Override
    public int updateHistoryLampInfoVotive(String fateOrder, String msisdn, String votiveType) {
    	return fateHistoryDAO.updateUserInfoVotive(fateOrder, msisdn, votiveType);
    }
    
    @Override
    public UserLampInfoVO getUserInfoVotive(String fateOrder) {
    	return userLampInfoDAO.getUserLampInfo(fateOrder);
    }
    
    @Override
    public List<FateHistoryVO> getFateOrderListByMsisdn(String msisdn) {
    	return fateHistoryDAO.getFateHistoryListBymsisdn(msisdn);
    }
}