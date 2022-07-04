package com.naturaltel.vo.api;

public class SessionUser {
    private String userid;
    private String userAccount;
    private String loginType;
    private String msisdn;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Override
    public String toString() {
        return "SessionUser [userid=" + userid + ", userAccount=" + userAccount + ", loginType=" + loginType
                + ", msisdn=" + msisdn + "]";
    }
}