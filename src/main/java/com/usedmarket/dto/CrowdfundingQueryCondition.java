package com.usedmarket.dto;

/**
 * Created by huangMP on 2016/11/26.
 * decription :
 */
public class CrowdfundingQueryCondition {

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
     * 查询数量
     */
    private String size;

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "CrowdfundingQueryCondition{" +
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
