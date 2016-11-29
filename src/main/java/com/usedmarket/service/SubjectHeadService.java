package com.usedmarket.service;

import com.usedmarket.entity.Carousel;
import com.usedmarket.entity.SubjectHead;

import java.util.List;

/**
 * Description：标题头service
 * Created by Peivxuan on 2016/11/29.
 */
public interface SubjectHeadService {

	/**
	 * 查找所有标题头
	 * @return 返回轮播图list
	 */
	List<SubjectHead> selectAll();

	/**
	 * 插入一个标题头
	 * @param subjectHead 要添加的轮播图
	 * @return 是否成功
	 */
	boolean insert(SubjectHead subjectHead);

	/**
	 * 通过标题头id删除标题头
	 * @param subjectHeadId 轮播图id
	 * @return 是否成功
	 */
	boolean deleteBySubjectHeadId(String subjectHeadId);

	/**
	 * 通过标题头id更新
	 * @param subjectHead 要更新的标题头
	 * @return 是否成功
	 */
	boolean updateBySubjectHeadId(SubjectHead subjectHead);

}
