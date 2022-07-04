package com.naturaltel.vo.db;

import java.io.Serializable;
import java.sql.Timestamp;

public class LogPageviewVO implements Serializable {

    private static final long serialVersionUID = -7933089857650100310L;

    private Integer indexId;
    private String sessionId;
    private String channel;
    private Timestamp createTime;
    private String msisdn;
    private String loginType;
    private String userAccount;
    private String userid;
    private String pageId;
    private String fromPageId;
    private String operator;

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getFromPageId() {
        return fromPageId;
    }

    public void setFromPageId(String fromPageId) {
        this.fromPageId = fromPageId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "LogPageviewVO{" +
                "indexId=" + indexId +
                ", sessionId='" + sessionId + '\'' +
                ", channel='" + channel + '\'' +
                ", createTime=" + createTime +
                ", msisdn='" + msisdn + '\'' +
                ", loginType='" + loginType + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userid='" + userid + '\'' +
                ", pageId='" + pageId + '\'' +
                ", fromPageId='" + fromPageId + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}