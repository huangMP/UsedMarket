package com.usedmarket.dao;

import com.usedmarket.entity.Crowdfunding;
import com.usedmarket.util.UuidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by huangMP on 2016/10/23.
 * decription : CrowdfundingDaoTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class CrowdfundingDaoTest {

    @Autowired
    CrowdfundingDao crowdfundingDao;

    @Test
    public void testInsert() throws Exception {
        Crowdfunding crowdfunding = new Crowdfunding();
        crowdfunding.setCrowdfundingId(UuidUtil.get32UUID());
        crowdfunding.setAddUser("1");
        crowdfundingDao.insert(crowdfunding);
        System.out.println(crowdfunding.toString());
    }

    @Test
    public void testFindByCrowdfundingId() throws Exception {
        Crowdfunding crowdfunding = crowdfundingDao.findByCrowdfundingId("1");
        System.out.println(crowdfunding.toString());
    }

    @Test
    public void testFindByaddUser() throws Exception {
        Crowdfunding crowdfunding = crowdfundingDao.findByaddUser("1");
        System.out.println(crowdfunding.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        Crowdfunding crowdfunding = crowdfundingDao.findByaddUser("1");
        crowdfunding.setAddDate(new Date());
        int i = crowdfundingDao.update(crowdfunding);
        System.out.println("更新数目："+i);
    }

    @Test
    public void testDelete() throws Exception {
        Crowdfunding crowdfunding = crowdfundingDao.findByaddUser("1");
        int i = crowdfundingDao.delete(crowdfunding.getCrowdfundingId());
        System.out.println("删除数目："+i);
    }
}