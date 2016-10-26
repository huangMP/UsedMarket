package com.usedmarket.dao;

import com.usedmarket.entity.UserInfo;
import com.usedmarket.util.MD5;
import com.usedmarket.util.UuidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huangMP on 2016/10/22.
 * decription : UserInfoDao 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class UserInfoDaoTest {

    @Autowired
    UserInfoDao userInfoDao;

    @Test
    public void testInsert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(UuidUtil.get32UUID());
        userInfo.setUsername("hmp");
        //将密码进行md5编码
        userInfo.setPassword( MD5.md5( "hmp" ) );

        userInfoDao.insert(userInfo);
        userInfo.toString();
    }

    @Test
    public void testFindByUserId() {
        UserInfo userInfo = userInfoDao.findByUserId("1");
        userInfo.toString();
    }

    @Test
    public void testFindByUsername() {
        UserInfo userInfo = userInfoDao.findByUsername("huangMP");
        userInfo.toString();
    }

    @Test
    public void testUpdate() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("京东");
        userInfo.setUsername("京东2");
        userInfo.setPassword("京东23");
        userInfoDao.update(userInfo);
    }

    @Test
    public void testDelete() {
        UserInfo userInfo = userInfoDao.findByUsername("huang1MP");
        userInfoDao.delete(userInfo.getUserId());
    }
}