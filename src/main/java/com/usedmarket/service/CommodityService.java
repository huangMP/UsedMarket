package com.usedmarket.service;

import com.usedmarket.dto.CommodityQueryCondition;
import com.usedmarket.entity.Commodity;
import com.usedmarket.entity.UserInfo;

import java.util.List;

/**
 * Created by peivxuan on 2016/10/24.
 * decription : 商品的 Service层接口
 */
public interface CommodityService {

    /**
     * 添加商品
     * @param product 新增的商品
     * @return
     */
    boolean addCommodity(Commodity product);

    /**
     * 通过商品id删除商品
     * @param commodityId 商品id
     * @return
     */
    boolean deleteByCommodityId(int commodityId);

    /**
     * 通过商品id更新商品
     * @param commodityId 商品id
     * @return
     */
    boolean updateByCommodityId(int commodityId);

    /**
     * 通过商品id查找商品
     * @param commodityId
     * @return
     */
    Commodity findByCommodityId(int commodityId);


    /**
     *
     * @param commodityQueryCondition 查询条件
     * @return
     */
    List<Commodity> findCommodityByQueryCondition(CommodityQueryCondition commodityQueryCondition);

}
