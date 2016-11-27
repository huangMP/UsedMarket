package com.usedmarket.service;

import com.usedmarket.dto.SecondHandSpecialCustom;
import com.usedmarket.entity.SecondHandSpecial;

import java.util.List;

/**
 * Created by huangMP on 2016/11/24.
 * decription :  Service层接口
 */
public interface SecondHandSpecialService {

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
