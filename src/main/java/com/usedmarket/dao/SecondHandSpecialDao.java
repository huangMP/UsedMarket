package com.usedmarket.dao;

import com.usedmarket.dto.SecondHandSpecialCustom;
import com.usedmarket.entity.SecondHandSpecial;

import java.util.List;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 二手专题 Dao
 */
public interface SecondHandSpecialDao {
    /**
     * 插入一条信息
     * @param secondHandSpecial
     * @return 插成功的数量
     */
    int insert(SecondHandSpecial secondHandSpecial) ;

    /**
     * 删除一条信息
     * @param secondHandSpecialId
     * @return 成功删除的信息条数
     */
    int delete(String secondHandSpecialId);

    /**
     * @param secondHandSpecialId
     * @return
     */
    SecondHandSpecial findBySecondHandSpecialId(String secondHandSpecialId) ;

    /**
     * @param secondHandSpecialId
     * @return
     */
    SecondHandSpecialCustom findSecondHandSpecialCustomBySecondHandSpecialId(String secondHandSpecialId);

    /**
     * @return
     */
    List<SecondHandSpecialCustom> findAll();

    /**
     * 修改
     * @param secondHandSpecial
     * @return
     */
    int update(SecondHandSpecial secondHandSpecial);
}
