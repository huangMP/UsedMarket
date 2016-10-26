package com.usedmarket.service.impl;

import com.usedmarket.dao.CommodityDao;
import com.usedmarket.dto.CommodityQueryCondition;
import com.usedmarket.entity.Commodity;
import com.usedmarket.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：enter your comment
 * Created by Peivxuan on 2016/10/24.
 */
@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	CommodityDao commodityDao;

	/**
	 * 添加商品
	 *
	 * @param product 新增的商品
	 * @return
	 */
	@Override
	public boolean addCommodity(Commodity product) {
		return commodityDao.insert(product);
	}

	/**
	 * 通过商品id删除商品
	 *
	 * @param commodityId 商品id
	 * @return
	 */
	@Override
	public boolean deleteByCommodityId(int commodityId) {
		return commodityDao.deleteByCommodityId(commodityId);
	}

	/**
	 * 通过商品id更新商品,不更新数量、收藏人数、销量
	 *
	 * @param commodityId 商品id
	 * @return
	 */
	@Override
	public boolean updateByCommodityId(int commodityId) {
		return commodityDao.updateByCommodityId(commodityId);
	}

	/**
	 * 通过商品id查找商品
	 *
	 * @param commodityId
	 * @return
	 */
	@Override
	public Commodity findByCommodityId(int commodityId) {
		return commodityDao.findByCommodityId(commodityId);
	}


	/**
	 * @param commodityQueryCondition 查询条件
	 * @return
	 */
	@Override
	public List<Commodity> findCommodityByQueryCondition(CommodityQueryCondition commodityQueryCondition) {
		return commodityDao.findCommodityByQueryCondition(commodityQueryCondition);
	}
}
