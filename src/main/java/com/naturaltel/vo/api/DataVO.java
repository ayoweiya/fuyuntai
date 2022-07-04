package com.naturaltel.vo.api;

import java.io.Serializable;
import java.sql.Timestamp;

public class DataVO implements Serializable {
	private static final long serialVersionUID = 3809669012480588413L;
	
	private String orderId;
    private String uid;
    private String commodityId;
    private Integer amount;
    private Integer buyUsage;
    private Integer useUsage;    
    private String callBackUrl;
    private String backUrl;
    private String userIp;
    private String countryPrefix;
    private String msisdn;
    private String channel;
    private String memo;    
    private String txId;
    private String resultCode;
    private String resultMsg;
    private String payTime;
    private Timestamp startTime;
    private Timestamp endTime;
    
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
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
	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		return "DataVO [orderId=" + orderId + ", uid=" + uid + ", commodityId=" + commodityId + ", amount=" + amount
				+ ", buyUsage=" + buyUsage + ", useUsage=" + useUsage + ", callBackUrl=" + callBackUrl + ", backUrl="
				+ backUrl + ", userIp=" + userIp + ", countryPrefix=" + countryPrefix + ", msisdn=" + msisdn
				+ ", channel=" + channel + ", memo=" + memo + ", txId=" + txId + ", resultCode=" + resultCode
				+ ", resultMsg=" + resultMsg + ", payTime=" + payTime + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}	
}