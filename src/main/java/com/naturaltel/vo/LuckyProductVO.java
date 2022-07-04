package com.naturaltel.vo;


import java.io.Serializable;
import java.sql.Timestamp;

public class LuckyProductVO implements Serializable {

    private int idx;
    private String fateOrder;
    private int hasLampInfo;
    private String createTime;
    private String Deliver_Way_LuckyProduct;
    private String Deliver_ID_LuckyProduct;
    private Timestamp Deliver_Time_LuckyProduct;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getFateOrder() {
        return fateOrder;
    }

    public void setFateOrder(String fateOrder) {
        this.fateOrder = fateOrder;
    }

    public int getHasLampInfo() {
        return hasLampInfo;
    }

    public void setHasLampInfo(int hasLampInfo) {
        this.hasLampInfo = hasLampInfo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDeliver_Way_LuckyProduct() {
        return Deliver_Way_LuckyProduct;
    }

    public void setDeliver_Way_LuckyProduct(String deliver_Way_LuckyProduct) {
        Deliver_Way_LuckyProduct = deliver_Way_LuckyProduct;
    }

    public String getDeliver_ID_LuckyProduct() {
        return Deliver_ID_LuckyProduct;
    }

    public void setDeliver_ID_LuckyProduct(String deliver_ID_LuckyProduct) {
        Deliver_ID_LuckyProduct = deliver_ID_LuckyProduct;
    }

    public Timestamp getDeliver_Time_LuckyProduct() {
        return Deliver_Time_LuckyProduct;
    }

    public void setDeliver_Time_LuckyProduct(Timestamp deliver_Time_LuckyProduct) {
        Deliver_Time_LuckyProduct = deliver_Time_LuckyProduct;
    }
}
