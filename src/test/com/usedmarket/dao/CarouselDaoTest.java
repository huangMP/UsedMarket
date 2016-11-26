package com.usedmarket.dao;

import com.usedmarket.entity.Carousel;
import com.usedmarket.util.UuidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Description：轮播图test
 * Created by Peivxuan on 2016/11/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class CarouselDaoTest {

	@Autowired
	CarouselDao carouselDao;

	@Test
	public void selectTop5() throws Exception {
		List<Carousel> carouselList = carouselDao.selectTop5();
		System.out.println(carouselList);
	}

	@Test
	public void insert() throws Exception {
		Carousel carousel = new Carousel();
		carousel.setAddDate(new Date());
		carousel.setAddUserId("222");
		carousel.setCarouselId(UuidUtil.get32UUID());
		carousel.setSort(0);
		carousel.setTitle("test2");

		System.out.println(carouselDao.insert(carousel)+"--------+++-----------");
	}

	@Test
	public void deleteByCarouselId() throws Exception {
		System.out.println(carouselDao.deleteByCarouselId("e1af4db2b40f4d7ca07924c597c6bc77"));
	}

	@Test
	public void updateByCarouselId() throws Exception {
		Carousel carousel = new Carousel();
		carousel.setAddDate(new Date());
		carousel.setAddUserId("111");
		carousel.setCarouselId("10eb8a5bf6e34020a11f0eb291aac956");
		carousel.setSort(1);
		System.out.println(carouselDao.updateByCarouselId(carousel));
	}
}