package com.naturaltel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.naturaltel.vo.db.TransIdPaymentComVO;

@Repository
public class TransIdPaymentComDAO extends BaseDAO {
    private JdbcOperations jdbcOperations;
    
    private static final String TABLE_NAME = DB_NAME + ".transid_paymentcom";

    @Autowired
    public TransIdPaymentComDAO(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
    
    public void insert(TransIdPaymentComVO vo) {    	
    	final String sql = "INSERT INTO " + TABLE_NAME + " (orderId, txId, sessionId, userip,"
    			+ " uid, countryPrefix, msisdn, channel, commodityId, amount, buyUsage, useUsage, memo, requestResultCode, requestResultMsg, requestTime)"
    			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, NOW())";
    	
    	logger.debug("SQL[{}], orderId=[{}], txId=[{}], sessionId=[{}], userip=[{}], uid=[{}],"
    			+ " countryPrefix=[{}], msisdn=[{}], channel=[{}], commodityId=[{}], amount=[{}], buyUsage=[{}]"
    			+ ", useUsage=[{}], memo=[{}], requestResultCode=[{}], requestResultMsg=[{}]",
    			sql, vo.getOrderId(), vo.getTxid(), vo.getSessionId(), vo.getUserip(), vo.getUid(),
    			vo.getCountryPrefix(), vo.getMsisdn(), vo.getChannel(), vo.getCommodityId(), vo.getAmount(), vo.getBuyUsage(),
    			vo.getUseUsage(), vo.getMemo(), vo.getRequestResultCode(), vo.getRequestResultMsg());
    	
    	jdbcOperations.update(sql, new Object[]{vo.getOrderId(), vo.getTxid(), vo.getSessionId(), vo.getUserip(), vo.getUid(),
    			vo.getCountryPrefix(), vo.getMsisdn(), vo.getChannel(), vo.getCommodityId(), vo.getAmount(), vo.getBuyUsage(),
    			vo.getUseUsage(), vo.getMemo(), vo.getRequestResultCode(), vo.getRequestResultMsg()});
    }
    
    public void update(TransIdPaymentComVO vo) {    	
    	final String sql = "UPDATE " + TABLE_NAME + " SET callBackResultCode = ?, callBackResultMsg = ?,"
    			+ " payTime = ?, realAmount = ?, realUseUsage = ? WHERE orderId = ?";
    	
    	logger.debug("SQL[{}], callBackResultCode=[{}], callBackResultMsg=[{}], payTime=[{}],"
    			+ " realAmount=[{}], realUseUsage=[{}], orderId=[{}]",
    			sql, vo.getCallBackResultCode(), vo.getCallBackResultMsg(), vo.getPayTime(), vo.getRealAmount(),
    			vo.getRealUseUsage(), vo.getOrderId());
    	
    	jdbcOperations.update(sql, new Object[]{vo.getCallBackResultCode(), vo.getCallBackResultMsg(),
    			vo.getPayTime(), vo.getRealAmount(), vo.getRealUseUsage(), vo.getOrderId()});
    }
    
    private class transIdPaymentComRowMapper implements RowMapper<TransIdPaymentComVO> {
        @Override
        public TransIdPaymentComVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        	
        	TransIdPaymentComVO paymentCom = new TransIdPaymentComVO();
        	paymentCom.setOrderId(rs.getString("orderId"));
        	paymentCom.setTxid(rs.getString("txid"));
        	paymentCom.setSessionId(rs.getString("sessionId"));
        	paymentCom.setUid(rs.getString("uid"));
        	paymentCom.setCommodityId(rs.getString("orderId"));
        	paymentCom.setAmount(rs.getInt("amount"));
        	paymentCom.setRealAmount(rs.getInt("realAmount"));
        	paymentCom.setBuyUsage(rs.getInt("buyUsage"));
        	paymentCom.setUseUsage(rs.getInt("useUsage"));
        	paymentCom.setRealUseUsage(rs.getInt("realUseUsage"));
        	paymentCom.setUserip(rs.getString("userip"));
        	paymentCom.setCountryPrefix(rs.getString("countryPrefix"));
        	paymentCom.setMsisdn(rs.getString("msisdn"));
        	paymentCom.setChannel(rs.getString("channel"));
        	paymentCom.setMemo(rs.getString("memo"));
        	paymentCom.setCreateTime(rs.getTimestamp("createTime"));
        	paymentCom.setUpdateTime(rs.getTimestamp("updateTime"));
        	paymentCom.setRequestResultCode(rs.getString("requestResultCode"));
        	paymentCom.setRequestResultMsg(rs.getString("requestResultMsg"));
        	paymentCom.setRequestTime(rs.getTimestamp("requestTime"));        	
        	paymentCom.setCallBackResultCode(rs.getString("callBackResultCode"));
        	paymentCom.setCallBackResultMsg(rs.getString("callBackResultMsg"));
        	paymentCom.setPayTime(rs.getString("payTime"));
        	
            return paymentCom;
        }
    }
    
    public String getMemoByOrderId(String orderid) {
    	String memo = "";
    	final String sql = "SELECT * FROM " + TABLE_NAME + " WHERE orderid = ?";    	
    	logger.debug("SQL[{}], idx=[{}]", sql, orderid);
    	
    	try {
    		TransIdPaymentComVO transIdPaymentComVO = jdbcOperations.queryForObject(sql, new Object[]{orderid}, new transIdPaymentComRowMapper());
    		
    		logger.info(transIdPaymentComVO);
        	if (transIdPaymentComVO != null && "0000".equals(transIdPaymentComVO.getCallBackResultCode())) {
        		memo = transIdPaymentComVO.getMemo();
        		logger.info(memo);
        	}
    	} catch (Exception e) {
    		logger.info(e);
    	}

        return memo;
    }
}