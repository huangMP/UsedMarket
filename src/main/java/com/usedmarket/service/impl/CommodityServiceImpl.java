package com.usedmarket.service.impl;

import com.usedmarket.dao.CommodityDao;
import com.usedmarket.dto.CommodityCustom;
import com.usedmarket.dto.CommodityQueryCondition;
import com.usedmarket.dto.ImageCustom;
import com.usedmarket.entity.Commodity;
import com.usedmarket.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：商品service实现类
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
	public boolean deleteByCommodityId(String commodityId) {
		return commodityDao.deleteByCommodityId(commodityId);
	}

	/**
	 * 通过商品id更新商品,不更新数量、收藏人数、销量
	 *
	 * @param commodityId 商品id
	 * @return
	 */
	@Override
	public boolean updateByCommodityId(String commodityId) {
		return commodityDao.updateByCommodityId(commodityId);
	}

	/**
	 * 通过商品id查找商品
	 *
	 * @param commodityId
	 * @return
	 */
	@Override
	public Commodity findByCommodityId(String commodityId) {
		return commodityDao.findByCommodityId(commodityId);
	}


	/**
	 * 通过条件查找商品
	 *
	 * @param commodityQueryCondition 查询条件
	 * @return
	 */
	@Override
	public List<CommodityCustom> findCommodityByQueryCondition(CommodityQueryCondition commodityQueryCondition) {
		if (commodityQueryCondition.getOrder() == null || "".equals(commodityQueryCondition.getOrder().trim())) {
			commodityQueryCondition.setOrder("DESC");
		}
		if (commodityQueryCondition.getOrderBy() == null || "".equals(commodityQueryCondition.getOrderBy().trim())) {
			commodityQueryCondition.setOrderBy("launch_date");
		}
		//取出10条commodity
		List<CommodityCustom> commodityCustoms = commodityDao.findCommodityByQueryCondition(commodityQueryCondition);
		//找出10条commodity的图片
		List<ImageCustom> imageCustoms = commodityDao.loadImages(commodityCustoms);
		//10commodity填入images
		for (int i = 0; i < commodityCustoms.size(); i++) {
			for (int j = 0; j < imageCustoms.size(); j++) {
				if (commodityCustoms.get(i).getCommodityId().equals(imageCustoms.get(j).getCommodityId())) {
					commodityCustoms.get(i).setImages(imageCustoms.get(j).getImages());
					break;
				}
			}
		}

		return commodityCustoms;
	}

	/**
	 * 通过商品名称以及商品详情查找商品
	 *
	 * @param indistinctField 查询条件
	 * @return
	 */
	@Override
	public List<CommodityCustom> findCommodityByNameAndDescription(String indistinctField) {
//		return commodityDao.findCommodityByNameAndDescription(indistinctField);

		//取出commodity
		List<CommodityCustom> commodityCustoms = commodityDao.findCommodityByNameAndDescription(indistinctField);
		//找出commodity的图片
		List<ImageCustom> imageCustoms = commodityDao.loadImages(commodityCustoms);
		//commodity填入images
		for (int i = 0; i < commodityCustoms.size(); i++) {
			for (int j = 0; j < imageCustoms.size(); j++) {
				if (commodityCustoms.get(i).getCommodityId().equals(imageCustoms.get(j).getCommodityId())) {
					commodityCustoms.get(i).setImages(imageCustoms.get(j).getImages());
					break;
				}
			}
		}

		return commodityCustoms;
	}


}
