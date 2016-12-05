package com.usedmarket.service;

import com.usedmarket.dto.DynamicsCustom;
import com.usedmarket.dto.QueryCondition;
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
    boolean insert(Dynamics dynamics);

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
    boolean update(Dynamics dynamics);

    /**
     * 按列查找 动态查找
     * @param queryCondition
     * @return
     */
    List<DynamicsCustom> findDynamicsByQueryCondition(QueryCondition queryCondition);

}
