package com.naturaltel.vo.db;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserLampInfoVO implements Serializable {
	private static final long serialVersionUID = 7634167927490449588L;

	private int idx;
	private String fateOrder;
	private String msisdn;
	private String name;
	private String birthDay;
	private String area;
	private String city;
	private String dist;
	private String road;
	private String wishMsg;
	private String name_luckyProduct;
	private String area_luckyProduct;
	private String city_luckyProduct;
	private String dist_luckyProduct;
	private String road_luckyProduct;
	private Timestamp createTime;

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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getWishMsg() {
		return wishMsg;
	}

	public void setWishMsg(String wishMsg) {
		this.wishMsg = wishMsg;
	}

	public String getName_luckyProduct() {
		return name_luckyProduct;
	}

	public void setName_luckyProduct(String name_luckyProduct) {
		this.name_luckyProduct = name_luckyProduct;
	}

	public String getArea_luckyProduct() {
		return area_luckyProduct;
	}

	public void setArea_luckyProduct(String area_luckyProduct) {
		this.area_luckyProduct = area_luckyProduct;
	}

	public String getCity_luckyProduct() {
		return city_luckyProduct;
	}

	public void setCity_luckyProduct(String city_luckyProduct) {
		this.city_luckyProduct = city_luckyProduct;
	}

	public String getDist_luckyProduct() {
		return dist_luckyProduct;
	}

	public void setDist_luckyProduct(String dist_luckyProduct) {
		this.dist_luckyProduct = dist_luckyProduct;
	}

	public String getRoad_luckyProduct() {
		return road_luckyProduct;
	}

	public void setRoad_luckyProduct(String road_luckyProduct) {
		this.road_luckyProduct = road_luckyProduct;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserLampInfoVO{" +
				"idx=" + idx +
				", fateOrder='" + fateOrder + '\'' +
				", msisdn='" + msisdn + '\'' +
				", name='" + name + '\'' +
				", birthDay='" + birthDay + '\'' +
				", area='" + area + '\'' +
				", city='" + city + '\'' +
				", dist='" + dist + '\'' +
				", road='" + road + '\'' +
				", wishMsg='" + wishMsg + '\'' +
				", name_luckyProduct='" + name_luckyProduct + '\'' +
				", area_luckyProduct='" + area_luckyProduct + '\'' +
				", city_luckyProduct='" + city_luckyProduct + '\'' +
				", dist_luckyProduct='" + dist_luckyProduct + '\'' +
				", road_luckyProduct='" + road_luckyProduct + '\'' +
				", createTime=" + createTime +
				'}';
	}
}