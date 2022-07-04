package com.naturaltel.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.naturaltel.base.BaseClass;
import com.naturaltel.constant.LogFormat;

public class BaseDAO extends BaseClass {
    protected final Logger logger = LogManager.getLogger(getClass());
    public static final String DB_NAME = "fate_fuyuntai";

    protected String defaultLogFormat(String sql, String logFormat) {
        return String.format(LogFormat.DEFAULT_DAO_LOG_FORMAT.getValue(), sql, logFormat);
    }

    protected String processSqlContainsIn(int parametersLength) {
        StringBuilder placeholdersString =  new StringBuilder("");
        for (int i = 1; i <= parametersLength; i++) {
            if(i != 1){
                placeholdersString.append(",");
            }
            placeholdersString.append("?");
        }
        return placeholdersString.toString();
    }
}