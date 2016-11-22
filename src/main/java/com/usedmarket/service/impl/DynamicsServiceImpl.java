package com.usedmarket.service.impl;

import com.usedmarket.dao.DynamicsDao;
import com.usedmarket.dto.DynamicsCustom;
import com.usedmarket.dto.DynamicsQueryCondition;
import com.usedmarket.entity.Dynamics;
import com.usedmarket.service.DynamicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 动态信息 Service层实现
 */
@Service
public class DynamicsServiceImpl implements DynamicsService {

    @Autowired
    DynamicsDao dynamicsDao;

    /**
     * 插入一条信息
     * @param dynamics
     * @return 插入成功的数量
     */
    @Override
    public int insert(Dynamics dynamics) {
        return dynamicsDao.insert(dynamics);
    }

    /**
     * @param dynamicsId
     * @return
     */
    @Override
    public Dynamics findByDynamicsId(String dynamicsId) {
        return dynamicsDao.findByDynamicsId( dynamicsId );
    }

    /**
     * 条件查找
     * @param dynamicsQueryCondition
     * @return
     */
    @Override
    public List<DynamicsCustom> findDynamicsByQueryCondition(DynamicsQueryCondition dynamicsQueryCondition){
        return dynamicsDao.findDynamicsByQueryCondition( dynamicsQueryCondition );
    }

    @Override
    public Dynamics update(Dynamics dynamics) {
        int i= dynamicsDao.update( dynamics );
        if( 0 < i ){
            return dynamics;
        }
        return null;
    }
}
