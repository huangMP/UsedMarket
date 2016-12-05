package com.usedmarket.service.impl;

import com.usedmarket.dao.CarouselDao;
import com.usedmarket.entity.Carousel;
import com.usedmarket.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：轮播图ServiceImpl
 * Created by Peivxuan on 2016/11/26.
 */
@Service
public class CarouselServiceImpl implements CarouselService {

	@Autowired
	private CarouselDao carouselDao;

	/**
	 * 查找前五张轮播图
	 *
	 * @return 返回轮播图list
	 */
	@Override
	public List<Carousel> selectTop5() {
		return carouselDao.selectTop5();
	}

	/**
	 * 插入一张轮播图
	 *
	 * @param carousel 要添加的轮播图
	 * @return 是否成功
	 */
	@Override
	public boolean insert(Carousel carousel) {
		return carouselDao.insert(carousel);
	}

	/**
	 * 通过轮播图id删除轮播图
	 *
	 * @param carouselId 轮播图id
	 * @return 是否成功
	 */
	@Override
	public boolean deleteByCarouselId(String carouselId) {
		return carouselDao.deleteByCarouselId(carouselId);
	}

	/**
	 * 通过轮播图id更新
	 *
	 * @param carousel 要更新的轮播图
	 * @return 是否成功
	 */
	@Override
	public boolean updateByCarouselId(Carousel carousel) {
		return carouselDao.updateByCarouselId(carousel);
	}
}
