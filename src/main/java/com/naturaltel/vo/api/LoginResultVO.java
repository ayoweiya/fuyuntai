package com.naturaltel.vo.api;
/**
 * judy on 2019/2/17
 */
public class LoginResultVO {
    private String result;
    private String message;
    private String loginId;

    public LoginResultVO(String result, String message) {
        this.result = result;
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Override
    public String toString() {
        return "LoginResultVO{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", loginId='" + loginId + '\'' +
                '}';
    }
}
