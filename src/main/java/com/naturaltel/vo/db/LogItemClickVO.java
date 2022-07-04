package com.naturaltel.vo.db;

import java.io.Serializable;
import java.sql.Timestamp;

public class LogItemClickVO implements Serializable {

    private static final long serialVersionUID = 6798671552631079206L;

    private Integer indexId;
    private String sessionId;
    private String channel;
    private String msisdn;
    private String loginType;
    private String userAccount;
    private String userid;
    private String pageId;
    private Integer itemType;
    private String itemId;
    private Timestamp createTime;
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

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "LogItemClickVO{" +
                "indexId=" + indexId +
                ", sessionId='" + sessionId + '\'' +
                ", channel='" + channel + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", loginType='" + loginType + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userid='" + userid + '\'' +
                ", pageId='" + pageId + '\'' +
                ", itemType=" + itemType +
                ", itemId='" + itemId + '\'' +
                ", createTime=" + createTime +
                ", operator='" + operator + '\'' +
                '}';
    }
}