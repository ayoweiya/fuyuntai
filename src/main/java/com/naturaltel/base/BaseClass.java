package com.naturaltel.base;

import com.naturaltel.constant.LogFormat;
import com.naturaltel.vo.api.SessionUser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseClass {
    protected final Logger logger = LogManager.getLogger(getClass());

    protected HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest();
    }

    protected HttpServletResponse getResponse() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attributes.getResponse();
    }

    protected HttpSession getSession(boolean create) {
        return getRequest().getSession(create);
    }

    protected HttpSession getSession() {
        return getSession(true);
    }

    protected String getSessionId() {
        return getSession().getId();
    }
    
    protected SessionUser getSessionUser() {
        SessionUser user = (SessionUser) getSession().getAttribute("SESSION_USER");
        return user;
    }
    
    protected void setSessionUser(SessionUser user) {
	getSession().setAttribute("SESSION_USER", user);
    }
    
    protected String defaultLogFormat(String logFormat) {
        return String.format(LogFormat.DEFAULT_CLASS_LOG_FORMAT.getValue(), logFormat);
    }

    protected String defaultMethodInvokeLogFormat() {
        return defaultLogFormat("method invoked.");
    }

    protected String defaultMethodExceptionLogFormat(Exception e) {
        return defaultLogFormat(String.format("exception occurred[%s]", e.getMessage()));
    }

    protected String defaultMethodExceptionLogFormat(Exception e, String logFormat) {
        return defaultLogFormat(String.format("exception occurred[%s]. %s", e.getMessage(), logFormat));
    }
}