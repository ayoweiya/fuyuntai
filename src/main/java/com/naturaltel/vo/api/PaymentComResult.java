package com.naturaltel.vo.api;

import java.sql.Timestamp;

public class PaymentComResult {
    private String resultCode;
    private String resultMsg;
    private String orderId;
    private String txId;
    private int commodity;
    private int usage;
    private Timestamp expireDate;
    private String media;
    private String payTime;
    private String uid;
    private int amount;
    private String serialNumber;
    private String memo;
    private String paymentCode;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }
    
    public int getCommodity() {
    	return commodity;
    }
    
    public void setCommodity(int commodity) {
    	this.commodity = commodity;
    }
    
    
    public int getUsage() {
    	return usage;
    }
    
    public void setUsage(int usage) {
    	this.usage = usage;
    }
    
    public Timestamp getExpireDate() {
    	return expireDate;
    }
    
    public void setExpireDate(Timestamp expireDate) {
    	this.expireDate = expireDate;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    @Override
    public String toString() {
        return "PaymentPageResult{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", orderId='" + orderId + '\'' +
                ", txId='" + txId + '\'' +
                ", commodity='" + commodity + '\'' +
                ", usage='" + usage + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", media='" + media + '\'' +
                ", payTime='" + payTime + '\'' +
                ", uid='" + uid + '\'' +
                ", amount=" + amount +
                ", serialNumber='" + serialNumber + '\'' +
                ", memo='" + memo + '\'' +
                ", paymentCode='" + paymentCode + '\'' +
                '}';
    }
}