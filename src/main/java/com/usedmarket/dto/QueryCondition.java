package com.usedmarket.dto;

/**
 * Description：查询条件
 * Created by huangMP on 2016/10/23.
 */
public class QueryCondition {

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

	/**
	 * 排序方式（DESC, ASC）
	 */
	private String order;

	/**
	 * 排序依据
	 */
	private String orderBy;

	/**
	 * 查询条数
	 */
	private int size;

	public QueryCondition() {
	}

	public QueryCondition(String type, String queryValue, String indistinctField,String order, String orderBy, int index,  int size) {
		this.type = type;
		this.indistinctField = indistinctField;
		this.queryValue = queryValue;
		this.index = index;
		this.order = order;
		this.orderBy = orderBy;
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {
		return "QueryCondition{" +
				"type='" + type + '\'' +
				", indistinctField='" + indistinctField + '\'' +
				", queryValue='" + queryValue + '\'' +
				", index=" + index +
				", order='" + order + '\'' +
				", orderBy='" + orderBy + '\'' +
				", size='" + size + '\'' +
				'}';
	}
}
