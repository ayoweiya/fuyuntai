package com.naturaltel.constant;

public enum LogFormat {
    DEFAULT_CONTROLLER_LOG_FORMAT("SessionID[%s], %s", "Controller預設Log格式"),
    DEFAULT_SERVICE_LOG_FORMAT("SessionID[%s], %s", "Service預設Log格式"),
    DEFAULT_DAO_LOG_FORMAT("SQL[%s], %s", "DAO預設Log格式"),
    DEFAULT_SERVICE_LOG_FORMAT_WITH_USERID("SessionID[%s], UserID[%s], %s", "Service預設Log格式（含帳號）"),
    DEFAULT_CLASS_LOG_FORMAT("%s", "預設Log格式");

    private String value;
    private String name;

    LogFormat(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}