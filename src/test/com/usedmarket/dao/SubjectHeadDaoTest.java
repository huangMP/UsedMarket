package com.usedmarket.dao;

import com.usedmarket.service.SubjectHeadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Description：enter your comment
 * Created by Peivxuan on 2016/11/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class SubjectHeadDaoTest {

	@Autowired
	SubjectHeadService subjectHeadService;

	@Test
	public void selectAll() throws Exception {
		subjectHeadService.selectAll();
	}

	@Test
	public void insert() throws Exception {

	}

	@Test
	public void deleteBySubjectHeadId() throws Exception {

	}

	@Test
	public void updateBySubjectHeadId() throws Exception {

	}
}