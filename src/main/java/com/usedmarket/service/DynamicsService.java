package com.usedmarket.service;

import com.usedmarket.dto.DynamicsCustom;
import com.usedmarket.dto.DynamicsQueryCondition;
import com.usedmarket.entity.Dynamics;

import java.util.List;

/**
 * Created by huangMP on 2016/11/18.
 * decription : 动态 的 Service层接口
 */
public interface DynamicsService {

    /**
     * 插入一条信息
     * @param dynamics
     * @return 插入成功的数量
     */
    public int insert(Dynamics dynamics);

    /**
     * @param dynamicsId
     * @return
     */
    public Dynamics findByDynamicsId(String dynamicsId);

    /**
     *
     * @param dynamics
     * @return
     */
    Dynamics update(Dynamics dynamics);

    /**
     * 按列查找 动态查找
     * @param dynamicsQueryCondition
     * @return
     */
    List<DynamicsCustom> findDynamicsByQueryCondition(DynamicsQueryCondition dynamicsQueryCondition);

}
