package com.usedmarket.entity;

/**
 * Description：推荐的头部
 * Created by Peivxuan on 2016/11/29.
 */
public class SubjectHead {

	/**
	 * 主键
	 */
	private String subjectHeadId;

	/**
	 * 推荐标题
	 */
	private String title;

	/**
	 * “更多”文字描述
	 */
	private String moreDes;

	/**
	 * 类型
	 */
	private Integer type;

	public SubjectHead() {
	}

	public SubjectHead(String subjectHeadId, String title, String moreDes, Integer type) {
		this.subjectHeadId = subjectHeadId;
		this.title = title;
		this.moreDes = moreDes;
		this.type = type;
	}

	public String getSubjectHeadId() {
		return subjectHeadId;
	}

	public void setSubjectHeadId(String subjectHeadId) {
		this.subjectHeadId = subjectHeadId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMoreDes() {
		return moreDes;
	}

	public void setMoreDes(String moreDes) {
		this.moreDes = moreDes;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SubjectHead{" +
				"subjectHeadId='" + subjectHeadId + '\'' +
				", title='" + title + '\'' +
				", moreDes='" + moreDes + '\'' +
				", type=" + type +
				'}';
	}
}
