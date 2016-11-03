package com.usedmarket.dao;

import com.usedmarket.dto.CommodityCustom;
import com.usedmarket.dto.CommodityQueryCondition;
import com.usedmarket.dto.ImageCustom;
import com.usedmarket.entity.Commodity;

import java.util.List;

/**
 * Description：商品dao
 * Created by Peivxuan on 2016/10/23.
 */
public interface CommodityDao {

	/**
	 * 插入商品
	 * @param product 商品
	 * @return 返回是否插入成功
	 */
	boolean insert(Commodity product);

	/**
	 * 通过商品id删除商品
	 * @param commodityId 商品id
	 * @return
	 */
	boolean deleteByCommodityId(String commodityId);

	/**
	 * 通过商品id更新商品
	 * @param commodityId 商品id
	 * @return
	 */
	boolean updateByCommodityId(String commodityId);

	/**
	 * 通过商品id查找商品
	 * @param commodityId
	 * @return
	 */
	Commodity findByCommodityId(String commodityId);

	/**
	 * 通过种类查找商品
	 * @param commodityQueryCondition 查找条件
	 * @return
	 */
	List<CommodityCustom> findCommodityByQueryCondition(CommodityQueryCondition commodityQueryCondition);

	/**
	 * 通过种类查找商品
	 * @param indistinctField 查找条件
	 * @return
	 */
	List<CommodityCustom> findCommodityByNameAndDescription(String indistinctField);

	/**
	 * 读取图片
	 * @param commodityCustom 需要其中的commodityId
	 * @return
	 */
	List<ImageCustom> loadImages(List<CommodityCustom> commodityCustom);

}
