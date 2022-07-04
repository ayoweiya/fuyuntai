package com.naturaltel.vo.db;

import java.io.Serializable;
import java.sql.Timestamp;

public class TransIdPaymentComVO implements Serializable {
	private static final long serialVersionUID = 2201988171176477070L;
	
	private String orderId;	
    private String txid;
    private String sessionId;
    private String uid;
    private String commodityId;
    private Integer amount;
    private Integer realAmount;
    private Integer buyUsage;
    private Integer useUsage;
    private Integer realUseUsage;
    private String userip;	
    private String countryPrefix;
    private String msisdn;
    private String channel;
    private String memo;
    private String callBackUrl;
    private String backUrl;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String requestResultCode;
    private String requestResultMsg;
    private Timestamp requestTime;
    private String callBackResultCode;
    private String callBackResultMsg;
    private String payTime;
    
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(Integer realAmount) {
		this.realAmount = realAmount;
	}
	public Integer getBuyUsage() {
		return buyUsage;
	}
	public void setBuyUsage(Integer buyUsage) {
		this.buyUsage = buyUsage;
	}
	public Integer getUseUsage() {
		return useUsage;
	}
	public void setUseUsage(Integer useUsage) {
		this.useUsage = useUsage;
	}
	public Integer getRealUseUsage() {
		return realUseUsage;
	}
	public void setRealUseUsage(Integer realUseUsage) {
		this.realUseUsage = realUseUsage;
	}
	public String getUserip() {
		return userip;
	}
	public void setUserip(String userip) {
		this.userip = userip;
	}
	public String getCountryPrefix() {
		return countryPrefix;
	}
	public void setCountryPrefix(String countryPrefix) {
		this.countryPrefix = countryPrefix;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCallBackUrl() {
		return callBackUrl;
	}
	public void setCallBackUrl(String callBackUrl) {
		this.callBackUrl = callBackUrl;
	}
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getRequestResultCode() {
		return requestResultCode;
	}
	public void setRequestResultCode(String requestResultCode) {
		this.requestResultCode = requestResultCode;
	}
	public String getRequestResultMsg() {
		return requestResultMsg;
	}
	public void setRequestResultMsg(String requestResultMsg) {
		this.requestResultMsg = requestResultMsg;
	}
	public Timestamp getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}
	public String getCallBackResultCode() {
		return callBackResultCode;
	}
	public void setCallBackResultCode(String callBackResultCode) {
		this.callBackResultCode = callBackResultCode;
	}
	public String getCallBackResultMsg() {
		return callBackResultMsg;
	}
	public void setCallBackResultMsg(String callBackResultMsg) {
		this.callBackResultMsg = callBackResultMsg;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	
	@Override
	public String toString() {
		return "TransIdPaymentComVO [orderId=" + orderId + ", txid=" + txid + ", sessionId=" + sessionId + ", uid="
				+ uid + ", commodityId=" + commodityId + ", amount=" + amount + ", realAmount=" + realAmount
				+ ", buyUsage=" + buyUsage + ", useUsage=" + useUsage + ", realUseUsage=" + realUseUsage + ", userip="
				+ userip + ", countryPrefix=" + countryPrefix + ", msisdn=" + msisdn + ", channel=" + channel
				+ ", memo=" + memo + ", callBackUrl=" + callBackUrl + ", backUrl=" + backUrl + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", requestResultCode=" + requestResultCode
				+ ", requestResultMsg=" + requestResultMsg + ", requestTime=" + requestTime + ", callBackResultCode="
				+ callBackResultCode + ", callBackResultMsg=" + callBackResultMsg + ", payTime=" + payTime + "]";
	}
	
}