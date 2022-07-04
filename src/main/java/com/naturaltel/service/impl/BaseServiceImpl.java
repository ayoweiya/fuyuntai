package com.naturaltel.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.naturaltel.base.BaseClass;
import com.naturaltel.constant.LogFormat;
import com.naturaltel.model.SystemPropertiesModel;


public class BaseServiceImpl extends BaseClass {
    protected final Logger logger = LogManager.getLogger(getClass());

    protected final SystemPropertiesModel properties;

    @Autowired
    public BaseServiceImpl(SystemPropertiesModel properties) {this.properties = properties;}

    @Override
    protected String defaultLogFormat(String logFormat) {
    	return String.format(LogFormat.DEFAULT_SERVICE_LOG_FORMAT.getValue(), getSessionId(), logFormat);
    }

    @Override
    protected String defaultMethodInvokeLogFormat() {
        return defaultLogFormat("method invoked.");
    }

    @Override
    protected String defaultMethodExceptionLogFormat(Exception e) {
        return defaultLogFormat(String.format("exception occurred[%s]", e.getMessage()));
    }
}
