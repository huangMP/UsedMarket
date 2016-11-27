package com.usedmarket.dto;

/**
 * Description：单文字表查询条件
 * Created by Peivxuan on 2016/11/26.
 */
public class SentenceQueryCondition {

	/**
	 * 查找类型
	 */
	private Integer type;

	/**
	 * 查询位置
	 */
	private Integer index;

	/**
	 * 数量
	 */
	private Integer num;

	/**
	 * 是否随机取数
	 */
	private Boolean doRandom;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Boolean isDoRandom() {
		return doRandom;
	}

	public void setDoRandom(Boolean doRandom) {
		this.doRandom = doRandom;
	}

	@Override
	public String toString() {
		return "SentenceQueryCondition{" +
				"type=" + type +
				", index=" + index +
				", num=" + num +
				", doRandom=" + doRandom +
				'}';
	}
}
