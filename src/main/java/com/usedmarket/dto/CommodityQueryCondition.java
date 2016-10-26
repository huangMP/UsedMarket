package com.usedmarket.dto;

/**
 * Description：商品查询条件
 * Created by Peivxuan on 2016/10/23.
 */
public class CommodityQueryCondition {

	/**
	 * 查询类型
	 */
	private String type;

	/**
	 * 模糊字段
	 */
	private String indistinctField;

	/**
	 * 查询值
	 */
	private String queryValue;

	/**
	 * 查询位置
	 */
	private int index;

	public CommodityQueryCondition() {
	}

	public CommodityQueryCondition(String type, String indistinctField, String queryValue, int index) {
		this.type = type;
		this.indistinctField = indistinctField;
		this.queryValue = queryValue;
		this.index = index;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIndistinctField() {
		return indistinctField;
	}

	public void setIndistinctField(String indistinctField) {
		this.indistinctField = indistinctField;
	}

	public String getQueryValue() {
		return queryValue;
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "CommodityQueryCondition{" +
				"type='" + type + '\'' +
				", indistinctField='" + indistinctField + '\'' +
				", queryValue='" + queryValue + '\'' +
				", index='" + index + '\'' +
				'}';
	}
}
