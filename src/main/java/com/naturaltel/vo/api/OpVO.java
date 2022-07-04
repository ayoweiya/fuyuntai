package com.naturaltel.vo.api;

import java.io.Serializable;

public class OpVO implements Serializable {
    private static final long serialVersionUID = 9051786091944294310L;
    
    private String sessionId;
    private String url;
    private String mode; //0:官網登入 1:遊戲登入 2:FB Account Kit
    private String otp;  //沒有OTP(目前僅有0)
    private String time; //YYYYMMDDhhmmss登入時間
    private String data; //要回傳的資料
    private String channel; //登入管道channel
    private String function; //登入方式 Normal fb google
    private String account; //登入成功的帳號
    private String userId;
    private String isChar;
    private String loginId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String loginId) {
        this.userId = loginId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    public String getIsChar() {
    	return isChar;
    }
    
    public void setIsChar(String isChar) {
    	this.isChar = isChar;
    }

    public String getLoginId() {
	return loginId;
    }
    
    public void setLoginId(String loginId) {
	this.loginId = loginId;
    }

    @Override
    public String toString() {
        return "OpVO{" +
                "sessionId='" + sessionId + '\'' +
                ", url='" + url + '\'' +
                ", mode='" + mode + '\'' +
                ", otp='" + otp + '\'' +
                ", time='" + time + '\'' +
                ", data='" + data + '\'' +
                ", channel='" + channel + '\'' +
                ", function='" + function + '\'' +
                ", account='" + account + '\'' +
                ", userId='" + userId + '\'' +
                ", isChar='" + isChar + '\'' +
                ", loginId='" + loginId + '\'' +
                '}';
    }
}