package com.naturaltel.support;

public class ActionResultStatus {
    public static final ActionResultStatus SUCCESS = new ActionResultStatus(1);
    public static final ActionResultStatus NOT_LIGIN = new ActionResultStatus(-1);
    public static final ActionResultStatus ERROR = new ActionResultStatus(-99);
    public static final ActionResultStatus DONOTHING = new ActionResultStatus(0);

    private int code;

    public ActionResultStatus(int code) {
        this.setCode(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}