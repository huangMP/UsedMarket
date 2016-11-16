package com.usedmarket.dao;

import com.usedmarket.entity.UserCollection;
import com.usedmarket.util.UuidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description：userCollectionDao 测试类
 * Created by Peivxuan on 2016/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class UserCollectionDaoTest {

	@Autowired
	UserCollectionDao userCollectionDao;

	@Test
	public void addCollection() throws Exception {

		UserCollection userCollection = new UserCollection();
		userCollection.setCollectionId(UuidUtil.get32UUID());
		userCollection.setCommodityId("5");
		userCollection.setUserId("333");
		userCollectionDao.addCollection(userCollection);

	}

	@Test
	public void removeOneCollection() throws Exception {
		UserCollection userCollection = new UserCollection();
		userCollection.setCollectionId(UuidUtil.get32UUID());
		userCollection.setCommodityId("1");
		userCollection.setUserId("333");
		userCollectionDao.removeOneCollection(userCollection);

	}

	@Test
	public void isExist() throws Exception {
		UserCollection userCollection = new UserCollection();
		//userCollection.setUserCollectionId(UuidUtil.get32UUID());
		userCollection.setCommodityId("10");
		userCollection.setUserId("333");
		System.out.println("------test-----------"+userCollectionDao.findOneCollection(userCollection));
	}
}