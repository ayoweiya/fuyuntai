package com.naturaltel.constant;

public class Config {
    private static String loggerName;
    
    public static String getLoggerName() {
    	return loggerName;
    }
    
    public static void setLoggerName(String loggerName) {
    	Config.loggerName = loggerName;
    }	
}