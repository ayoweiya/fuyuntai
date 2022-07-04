package com.naturaltel.service;

import java.util.List;

import com.naturaltel.vo.api.DataVO;
import com.naturaltel.vo.api.PaymentComResult;
import com.naturaltel.vo.db.FateHistoryVO;
import com.naturaltel.vo.db.TransIdPaymentComVO;
import com.naturaltel.vo.db.UserLampInfoVO;
import com.naturaltel.vo.db.ViewProjectVO;

public interface HomeService {
	void insertApiLog(String method, String param, String type, String ip);
	
	public int getNextVal(String sequenceName);
	
	PaymentComResult getTxIdResult(String cid, DataVO dataVO, String ip);
	
	String useUsageUrl(String txId, DataVO dataVO);
	
	void insertOrder(TransIdPaymentComVO vo);
	
	DataVO decryptDataVO(String cid, String dataStr);
	
	void updateOrder(TransIdPaymentComVO vo);
	
	String getMemoByOrderId(String orderid);
	
	ViewProjectVO getProjectByIdx(String idx);
	
	int insertHistory(String fateOrder, String msisdn, String lampType);
	
	FateHistoryVO getFateHistoryByOrderId(String fateOrder);
	
	List<FateHistoryVO> getFateHistoryByMsisdnAndType(String msisdn, String lampType);
	
	int updateHistoryLampInfo(String fateOrder, String msisdn);
	
	void insertUserLampInfo(UserLampInfoVO userLampInfoVO);
	
	int updateHistoryLampInfoVotive(String fateOrder, String msisdn, String votiveType);
	
	UserLampInfoVO getUserInfoVotive(String fateOrder);
	
	List<FateHistoryVO> getFateOrderListByMsisdn(String msisdn);
}