package com.naturaltel.support;

public class ActionResult {

    private ActionResultStatus status;
    private Object result;

    private String REQUEST_ID;
    private String RESULT_CODE;
    private String RESULT_MSG;
    private String RESULT_DATA;

    public String getREQUEST_ID() {
        return REQUEST_ID;
    }

    public void setREQUEST_ID(String REQUEST_ID) {
        this.REQUEST_ID = REQUEST_ID;
    }

    public String getRESULT_CODE() {
        return RESULT_CODE;
    }

    public void setRESULT_CODE(String RESULT_CODE) {
        this.RESULT_CODE = RESULT_CODE;
    }

    public String getRESULT_MSG() {
        return RESULT_MSG;
    }

    public void setRESULT_MSG(String RESULT_MSG) {
        this.RESULT_MSG = RESULT_MSG;
    }

    public String getRESULT_DATA() {
        return RESULT_DATA;
    }

    public void setRESULT_DATA(String RESULT_DATA) {
        this.RESULT_DATA = RESULT_DATA;
    }

    private ActionResult() {
    }

    public static ActionResult createResult(ActionResultStatus status) {
        ActionResult result = new ActionResult();
        result.setStatus(status);
        return result;
    }

    public static ActionResult createSuccessResult() {
        return createResult(ActionResultStatus.SUCCESS);
    }

    public static ActionResult createErrorResult() {
        return createResult(ActionResultStatus.ERROR);
    }

    public ActionResultStatus getStatus() {
        return status;
    }

    public void setStatus(ActionResultStatus status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ActionResult [status=" + status + ", result=" + result + ']';
    }

}