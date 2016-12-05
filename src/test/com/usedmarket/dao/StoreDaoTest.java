package com.usedmarket.dao;

import com.usedmarket.dto.QueryCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Description：enter your comment
 * Created by Peivxuan on 2016/12/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class StoreDaoTest {

	@Autowired
	private StoreDao storeDao;

	@Test
	public void insert() throws Exception {

	}

	@Test
	public void findByQueryCondition() throws Exception {
		System.out.println(storeDao.findByQueryCondition(new QueryCondition("all", "", "", "DESC", "registration_date", 0, 3)));
	}
}