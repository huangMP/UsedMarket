package com.usedmarket.service.impl;

import com.usedmarket.dao.CommodityCategoryDao;
import com.usedmarket.entity.CommodityCategory;
import com.usedmarket.entity.CommodityCategoryCustom;
import com.usedmarket.service.CommodityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangMP on 2016/11/24.
 * decription : Service层实现
 */
@Service
public class CommodityCategoryServiceImpl implements CommodityCategoryService {

    @Autowired
    CommodityCategoryDao commodityCategoryDao;

    @Override
    public int insert(CommodityCategory commodityCategory) {
        return commodityCategoryDao.insert(commodityCategory);
    }

    @Override
    public int delete(String commodityCategoryId) {
        return commodityCategoryDao.delete(commodityCategoryId);
    }

    @Override
    public CommodityCategory findByCommodityCategoryId(String commodityCategoryId) {
        return commodityCategoryDao.findByCommodityCategoryId(commodityCategoryId);
    }

    @Override
    public CommodityCategoryCustom findCommodityCategoryCustomByCommodityCategoryId(String commodityCategoryId) {
        return commodityCategoryDao.findCommodityCategoryCustomByCommodityCategoryId(commodityCategoryId);
    }

    @Override
    public List<CommodityCategoryCustom> findAll() {
        return commodityCategoryDao.findAll();
    }

    /**
     * 修改
     * @param commodityCategory
     * @return
     */
    public int update(CommodityCategory commodityCategory){
        return commodityCategoryDao.update(commodityCategory);
    }
}
