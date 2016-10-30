package com.usedmarket.dao;

import com.usedmarket.dto.CommodityQueryCondition;
import com.usedmarket.entity.Commodity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Description：enter your comment
 * Created by Peivxuan on 2016/10/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class CommodityDaoTest {

	@Autowired
	CommodityDao commodityDao;

	@Test
	public void findCommodityByQueryCondition() throws Exception {
		CommodityQueryCondition commodityQueryCondition = new CommodityQueryCondition();
		commodityQueryCondition.setIndex(0);
		commodityQueryCondition.setType("category");// all =
		commodityQueryCondition.setQueryValue("123");
		commodityQueryCondition.setIndistinctField("大宝");
		//List<Commodity> commodities = commodityDao.findCommodityByQueryCondition(commodityQueryCondition);
		//System.out.println(commodities);
	}

	@Test
	public void addCommodity() throws Exception {
		Commodity commodity = new Commodity();
		commodity.setCommodityId("234234243");
		System.out.println(commodityDao.insert(commodity));
	}

	@Test
	public void findCommodityByOtherAttribute() throws Exception {
		System.out.println(commodityDao.findCommodityByNameAndDescription("衣"));
	}

}