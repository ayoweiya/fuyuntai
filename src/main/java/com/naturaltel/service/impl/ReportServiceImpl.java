package com.naturaltel.service.impl;

import com.naturaltel.dao.*;
import com.naturaltel.service.ReportService;
import com.naturaltel.util.ErrorUtils;
import com.naturaltel.vo.db.LogItemClickVO;
import com.naturaltel.vo.db.LogPageviewVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private final LogPageviewDAO logPageviewDAO;
    @Autowired
    private final LogItemClickDAO logItemClickDAO;

    public ReportServiceImpl(LogPageviewDAO logPageviewDAO, LogItemClickDAO logItemClickDAO) {
        this.logPageviewDAO = logPageviewDAO;
        this.logItemClickDAO = logItemClickDAO;
    }

    @Override
    public int addPageView(String sessionId, String  channel,String msisdn, String loginType, String userAccount, String userid,
            String pageId, String fromPageId, String operator) {
	int result = 0;	
        try {
            LogPageviewVO vo = new LogPageviewVO();
            vo.setSessionId(sessionId);
            vo.setChannel(channel);
            vo.setMsisdn( msisdn);
            vo.setLoginType( loginType);
            vo.setUserAccount(userAccount);
            vo.setUserid( userid);
            vo.setPageId( pageId);
            vo.setFromPageId(fromPageId == null ? pageId : fromPageId);
            vo.setOperator(operator);
            result = logPageviewDAO.insert(vo);
        } catch (Exception e) {
            ErrorUtils.error(logger, e);
        }
        return result;
    }

    @Override
    public int addItemClick(String sessionId, String  channel ,String msisdn, String loginType, String userAccount, String userid,
            String pageId, int itemType, String itemId, String operator) {
        int result = 0;
        try {
            LogItemClickVO vo = new LogItemClickVO();
            vo.setSessionId(sessionId);
            vo.setChannel(channel);
            vo.setMsisdn(msisdn);
            vo.setLoginType(loginType);
            vo.setUserAccount(userAccount);
            vo.setUserid(userid);
            vo.setPageId(pageId);
            vo.setItemType(itemType);
            vo.setItemId(itemId);
            vo.setOperator(operator);
            result = logItemClickDAO.insert(vo);
        } catch (Exception e) {
            ErrorUtils.error(logger, e);
        }
        return result;
    }
}