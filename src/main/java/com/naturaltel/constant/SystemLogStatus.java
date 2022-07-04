package com.naturaltel.constant;

public enum SystemLogStatus {
    SUCCESS("成功", "1"), FAILURE("失敗", "0");
    private String name;
    private String value;

    SystemLogStatus(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public int getCode() {
        return Integer.parseInt(getValue());
    }
}