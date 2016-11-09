package com.usedmarket.dao;

import com.usedmarket.dto.CommodityCustom;
import com.usedmarket.dto.CommodityQueryCondition;
import com.usedmarket.dto.ImageCustom;
import com.usedmarket.entity.Commodity;
import com.usedmarket.service.CommodityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Description：enter your comment
 * Created by Peivxuan on 2016/10/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class CommodityDaoTest {

	@Autowired
	CommodityService commodityService;

	@Autowired
	CommodityDao commodityDao;

	@Test
	public void findCommodityByQueryCondition() throws Exception {
		CommodityQueryCondition commodityQueryCondition = new CommodityQueryCondition();
		commodityQueryCondition.setIndex(0);
		commodityQueryCondition.setType("all");
		commodityQueryCondition.setOrder("");
		commodityQueryCondition.setOrderBy("");
		//commodityQueryCondition.setQueryValue("123");
		//commodityQueryCondition.setIndistinctField("大宝");
		List<CommodityCustom> commodities = commodityService.findCommodityByQueryCondition(commodityQueryCondition);
		System.out.println(commodities);
	}

	@Test
	public void updateCommodity() throws Exception {
		Commodity commodity = new Commodity();
		commodity.setCommodityId("1");
		commodity.setPreferNum(100);
		commodity.setAmount(1000);
		commodity.setPrice(1000.10);
		commodity.setSalesVolume(500);
		commodity.setStatus(1);
		commodityService.updateNumByCommodityId(commodity);
		//System.out.println(commodityService.insert(commodity));
	}

	@Test
	public void loadImageTest() throws Exception {

//		List<CommodityCustom> commodityCustoms = new ArrayList<CommodityCustom>();
//		CommodityCustom commodityCustom = new CommodityCustom();
//		commodityCustom.setCommodityId("1");
//		commodityCustoms.add(commodityCustom);
//
//		commodityCustom = new CommodityCustom();
//		commodityCustom.setCommodityId("2");
//		commodityCustoms.add(commodityCustom);
//
//		commodityCustom = new CommodityCustom();
//		commodityCustom.setCommodityId("3");
//		commodityCustoms.add(commodityCustom);
//
//		commodityCustom = new CommodityCustom();
//		commodityCustom.setCommodityId("4");
//		commodityCustoms.add(commodityCustom);
//
//		commodityCustom = new CommodityCustom();
//		commodityCustom.setCommodityId("5");
//		commodityCustoms.add(commodityCustom);

		CommodityQueryCondition commodityQueryCondition = new CommodityQueryCondition();
		commodityQueryCondition.setType("all");
		commodityQueryCondition.setOrder("DESC");
		commodityQueryCondition.setOrderBy("launch_date");
		commodityQueryCondition.setIndex(0);

		List<CommodityCustom> commodityCustoms = commodityDao.findCommodityByQueryCondition(commodityQueryCondition);

		List<ImageCustom> imageCustoms = commodityDao.loadImages(commodityCustoms);

		System.out.println(imageCustoms);


	}

}