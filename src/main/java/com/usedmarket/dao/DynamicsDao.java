package com.usedmarket.dao;


import com.usedmarket.dto.DynamicsCustom;
import com.usedmarket.dto.DynamicsQueryCondition;
import com.usedmarket.entity.Dynamics;

import java.util.List;

/**
 * Created by huangMP on 2016/11/18.
 * decription : 动态 的 Dao
 */
public interface DynamicsDao {

    /**
     * 插入一条信息
     * @param dynamics
     * @return 插入成功的数量
     */
    int insert(Dynamics dynamics) ;

    /**
     * @param dynamicsId
     * @return
     */
    Dynamics findByDynamicsId(String dynamicsId);

    /**
     * 按列查找 捐赠动态
     * @param dynamicsQueryCondition
     * @return
     */
    List<DynamicsCustom> findDanotionDynamicsByQueryCondition(DynamicsQueryCondition dynamicsQueryCondition);

    /**
     * 按列查找 校园动态
     * @param dynamicsQueryCondition
     * @return
     */
    List<DynamicsCustom> findSchoolDynamicsByQueryCondition(DynamicsQueryCondition dynamicsQueryCondition);
    /**
     * @param dynamics
     * @return
     */
    int update(Dynamics dynamics);
}
