package com.usedmarket.dao;

import com.usedmarket.entity.SentenceBean;
import com.usedmarket.util.UuidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Description：单句子test
 * Created by Peivxuan on 2016/11/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class SentenceDaoTest {

	@Autowired
	private SentenceDao sentenceDao;

	@Test
	public void selectSentencesByCondition() throws Exception {

	}

	@Test
	public void insert() throws Exception {
		SentenceBean sentenceBean = new SentenceBean();
		for (int i = 0; i < 5 ; i++) {
			sentenceBean.setSentenceId(UuidUtil.get32UUID());
			sentenceBean.setAddDate(new Date());
			sentenceBean.setText("跑马条"+(i+1));
			sentenceBean.setType(1);
			System.out.println(sentenceDao.insert(sentenceBean));
		}
	}

	@Test
	public void deleteBySentenceId() throws Exception {

	}

	@Test
	public void updateBySentenceId() throws Exception {

	}

	@Test
	public void selectNumByType() throws Exception {

	}
}