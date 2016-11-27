package com.usedmarket.dao;

import com.usedmarket.dto.CommodityCategoryCustom;
import com.usedmarket.entity.CommodityCategory;

import java.util.List;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 用户信息 Dao
 */
public interface CommodityCategoryDao {
    /**
     * 插入一条信息
     * @param commodityCategory
     * @return 插入成功的数量
     */
    int insert(CommodityCategory commodityCategory) ;

    /**
     * 删除一条信息
     * @param commodityCategoryId
     * @return 成功删除的信息条数
     */
    int delete(String commodityCategoryId);

    /**
     * @param commodityCategoryId
     * @return
     */
    CommodityCategory findByCommodityCategoryId(String commodityCategoryId) ;

    /**
     * @param commodityCategoryId
     * @return
     */
    CommodityCategoryCustom findCommodityCategoryCustomByCommodityCategoryId(String commodityCategoryId);

    /**
     * @return
     */
    List<CommodityCategoryCustom> findAll();

    /**
     * 修改
     * @param commodityCategory
     * @return
     */
    int update(CommodityCategory commodityCategory);
}
