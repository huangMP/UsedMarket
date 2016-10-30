package com.usedmarket.entity;

import java.util.Date;

/**
 * Description：商品类
 * Created by Peivxuan on 2016/10/23.
 */
public class Commodity {

	/**
	 * 商品id
	 */
	private String commodityId;

	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 商店id
	 */
	private String storeId;

	/**
	 * 商品名称
	 */
	private String commodityName;

	/**
	 * 分类
	 */
	private String category;

	/**
	 * 价格
	 */
	private double price;

	/**
	 * 数量
	 */
	private int amount;

	/**
	 * 图片
	 */
	private String images;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 当前定位
	 */
	private String location;

	/**
	 * 收藏人数
	 */
	private int preferNum;

	/**
	 * 上架时间
	 */
	private Date launchDate;

	/**
	 * 销售量
	 */
	private int salesVolume;

	public Commodity() {
	}

	public Commodity(String commodityId, String userId, String storeId, String commodityName, String category, double price, int amount, String images, String description, String location, int preferNum, Date launchDate, int salesVolume) {
		this.commodityId = commodityId;
		this.userId = userId;
		this.storeId = storeId;
		this.commodityName = commodityName;
		this.category = category;
		this.price = price;
		this.amount = amount;
		this.images = images;
		this.description = description;
		this.location = location;
		this.preferNum = preferNum;
		this.launchDate = launchDate;
		this.salesVolume = salesVolume;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPreferNum() {
		return preferNum;
	}

	public void setPreferNum(int preferNum) {
		this.preferNum = preferNum;
	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	public int getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Commodity{" +
				"commodityId='" + commodityId + '\'' +
				", userId='" + userId + '\'' +
				", storeId='" + storeId + '\'' +
				", commodityName='" + commodityName + '\'' +
				", category='" + category + '\'' +
				", price=" + price +
				", amount=" + amount +
				", images='" + images + '\'' +
				", description='" + description + '\'' +
				", preferNum=" + preferNum +
				", launchDate=" + launchDate +
				", salesVolume=" + salesVolume +
				", location=" + location +
				'}';
	}
}
