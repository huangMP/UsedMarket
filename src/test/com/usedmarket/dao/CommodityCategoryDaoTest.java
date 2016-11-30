package com.usedmarket.dao;

import com.usedmarket.dto.CommodityCategoryCustom;
import com.usedmarket.entity.CommodityCategory;
import com.usedmarket.util.UuidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by huangMP on 2016/11/24.
 * decription : CommodityCategoryDao 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class CommodityCategoryDaoTest {

    @Autowired
    CommodityCategoryDao commodityCategoryDao;

    @Test
    public void insert() {
        CommodityCategory commodityCategory = new CommodityCategory();
        commodityCategory.setCommodityCategoryId(UuidUtil.get32UUID());
        commodityCategory.setAddDate(new Date());
       // commodityCategory.setCommodityCategoryName("分类1");
        commodityCategoryDao.insert(commodityCategory);
        System.out.println("操作完成");
    }

    @Test
    public void findByCommodityCategoryId() {
        CommodityCategory commodityCategory = commodityCategoryDao.findByCommodityCategoryId("ba05aa098fd849c9a8d82e50228c3ab2");
        System.out.println(commodityCategory.toString());
        System.out.println("操作完成");
    }

    @Test
    public void findCommodityCategoryCustomByCommodityCategoryId() {
        CommodityCategory commodityCategory = commodityCategoryDao.findCommodityCategoryCustomByCommodityCategoryId("ba05aa098fd849c9a8d82e50228c3ab2");
        System.out.println(commodityCategory.toString());
        System.out.println("操作完成");
    }

    @Test
    public void findAll() {
        List<CommodityCategoryCustom> list = commodityCategoryDao.findAll();
        System.out.println(list.size());
        System.out.println("操作完成");
    }
}