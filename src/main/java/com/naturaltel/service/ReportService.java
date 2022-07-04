package com.naturaltel.service;

public interface ReportService {
    int addPageView(String sessionId, String  channel, String msisdn, String loginType, String userAccount, String userid, String pageId,
                    String fromPageId, String operator) throws Exception;

    int addItemClick(String sessionId, String  channel, String msisdn, String loginType, String userAccount, String userid,
                     String pageId, int itemType, String itemId, String operator) throws Exception;
}