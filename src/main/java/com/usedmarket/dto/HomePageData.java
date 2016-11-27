package com.usedmarket.dto;

import com.usedmarket.entity.Carousel;
import com.usedmarket.entity.SentenceBean;
import com.usedmarket.entity.Store;

import java.util.List;

/**
 * Description：首页展示数据
 * Created by Peivxuan on 2016/11/27.
 */
public class HomePageData {

	/**
	 * 轮播图
	 */
	private List<Carousel> carouselList;

	/**
	 * 跑马条
	 */
	private List<SentenceBean> sentenceBeanList;

	/**
	 * 二手专题
	 */
	private List<SecondHandSpecialCustom> secondHandSpecialCustomList;

	/**
	 * 众筹
	 */
	private List<CrowdfundingCustom> crowdfundingCustomList;

	/**
	 * 动态
	 */
	private List<DynamicsCustom> dynamicsCustomList;

	/**
	 * 店铺
	 */
	private List<Store> storeList;

	public HomePageData() {
	}

	public HomePageData(List<Carousel> carouselList, List<SentenceBean> sentenceBeanList, List<SecondHandSpecialCustom> secondHandSpecialCustomList, List<CrowdfundingCustom> crowdfundingCustomList, List<DynamicsCustom> dynamicsCustomList, List<Store> storeList) {
		this.carouselList = carouselList;
		this.sentenceBeanList = sentenceBeanList;
		this.secondHandSpecialCustomList = secondHandSpecialCustomList;
		this.crowdfundingCustomList = crowdfundingCustomList;
		this.dynamicsCustomList = dynamicsCustomList;
		this.storeList = storeList;
	}

	public List<Store> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}

	public List<Carousel> getCarouselList() {
		return carouselList;
	}

	public void setCarouselList(List<Carousel> carouselList) {
		this.carouselList = carouselList;
	}

	public List<SentenceBean> getSentenceBeanList() {
		return sentenceBeanList;
	}

	public void setSentenceBeanList(List<SentenceBean> sentenceBeanList) {
		this.sentenceBeanList = sentenceBeanList;
	}

	public List<SecondHandSpecialCustom> getSecondHandSpecialCustomList() {
		return secondHandSpecialCustomList;
	}

	public void setSecondHandSpecialCustomList(List<SecondHandSpecialCustom> secondHandSpecialCustomList) {
		this.secondHandSpecialCustomList = secondHandSpecialCustomList;
	}

	public List<CrowdfundingCustom> getCrowdfundingCustomList() {
		return crowdfundingCustomList;
	}

	public void setCrowdfundingCustomList(List<CrowdfundingCustom> crowdfundingCustomList) {
		this.crowdfundingCustomList = crowdfundingCustomList;
	}

	public List<DynamicsCustom> getDynamicsCustomList() {
		return dynamicsCustomList;
	}

	public void setDynamicsCustomList(List<DynamicsCustom> dynamicsCustomList) {
		this.dynamicsCustomList = dynamicsCustomList;
	}

	@Override
	public String toString() {
		return "HomePageData{" +
				"storeList=" + storeList +
				", dynamicsCustomList=" + dynamicsCustomList +
				", crowdfundingCustomList=" + crowdfundingCustomList +
				", secondHandSpecialCustomList=" + secondHandSpecialCustomList +
				", sentenceBeanList=" + sentenceBeanList +
				", carouselList=" + carouselList +
				'}';
	}
}
