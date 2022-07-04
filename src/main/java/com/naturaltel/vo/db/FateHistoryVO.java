package com.naturaltel.vo.db;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

public class FateHistoryVO implements Serializable {
	private static final long serialVersionUID = 4254562941663519196L;

	private int idx;
	private String fateOrder;
	private String msisdn;
	private String lampType;
	private int hasLampInfo;
	private String buyTime;
	private int isVotive;
	private String votiveType;
	private Timestamp votiveTime;
	private String votiveTimes;
	private String Deliver_Way_LuckyProduct;
	private String Deliver_ID_LuckyProduct;
	private Timestamp Deliver_Time_LuckyProduct;
	private Timestamp createTime;
	private Timestamp updateTime;

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
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getLampType() {
		return lampType;
	}
	public void setLampType(String lampType) {
		this.lampType = lampType;
	}
	public int getHasLampInfo() {
		return hasLampInfo;
	}
	public void setHasLampInfo(int hasLampInfo) {
		this.hasLampInfo = hasLampInfo;
	}
	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	public int getIsVotive() {
		return isVotive;
	}
	public void setIsVotive(int isVotive) {
		this.isVotive = isVotive;
	}
	public String getVotiveType() {
		return votiveType;
	}
	public void setVotiveType(String votiveType) {
		this.votiveType = votiveType;
	}
	public Timestamp getVotiveTime() {
		return votiveTime;
	}

	public void setVotiveTime(Timestamp votiveTime) {
		this.votiveTime = votiveTime;
	}

	public String getVotiveTimes() {
		return votiveTimes;
	}

	public void setVotiveTimes(String votiveTimes) {
		this.votiveTimes = votiveTimes;
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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "FateHistoryVO{" +
				"idx=" + idx +
				", fateOrder='" + fateOrder + '\'' +
				", msisdn='" + msisdn + '\'' +
				", lampType='" + lampType + '\'' +
				", hasLampInfo=" + hasLampInfo +
				", buyTime='" + buyTime + '\'' +
				", isVotive=" + isVotive +
				", votiveType='" + votiveType + '\'' +
				", votiveTime=" + votiveTime +
				", votiveTimes='" + votiveTimes + '\'' +
				", Deliver_Way_LuckyProduct='" + Deliver_Way_LuckyProduct + '\'' +
				", Deliver_ID_LuckyProduct=" + Deliver_ID_LuckyProduct +
				", Deliver_Time_LuckyProduct=" + Deliver_Time_LuckyProduct +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}

}