package com.usedmarket.controller.app;

import com.usedmarket.dto.*;
import com.usedmarket.entity.Carousel;
import com.usedmarket.entity.SentenceBean;
import com.usedmarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description：首页展示数据的controller
 * Created by Peivxuan on 2016/11/27.
 */
@Controller
@RequestMapping("/HomePage")
public class HomePageController {

	/**
	 * 轮播图service
	 */
	@Autowired
	private CarouselService carouselService;

	/**
	 * 单文字service
	 */
	@Autowired
	private SentenceService sentenceService;

	/**
	 * 二手专题
	 */
	@Autowired
	private SecondHandSpecialService secondHandSpecialService;

	/**
	 * 动态
	 */
	@Autowired
	private DynamicsService dynamicsService;

	/**
	 * 众筹
	 */
	@Autowired
	private CrowdfundingService crowdfundingService;

	@RequestMapping("/display")
	@ResponseBody
	public HttpResult HomePageDataDisplay() {
		//五条轮播图
		List<Carousel> carouselList = carouselService.selectTop5();
		//五条跑马条
		List<SentenceBean> sentenceBeanList = sentenceService.selectSentencesByCondition(new SentenceQueryCondition(1, 0, 5, false));
		//全部二手专题
		List<SecondHandSpecialCustom> secondHandSpecialCustomList = secondHandSpecialService.findAll();
		//五条众筹
		List<CrowdfundingCustom> crowdfundingCustomList = crowdfundingService.findCrowdfundingQueryCondition(new CrowdfundingQueryCondition("all", "", "", 0, "DESC", "add_date", "5"));
		//五条动态
		List<DynamicsCustom> dynamicsCustomList = dynamicsService.findDynamicsByQueryCondition(new DynamicsQueryCondition("all", "", "", 0, "DESC", "add_date", ""));

		return new HttpResult<HomePageData>(new HomePageData(
				carouselList,
				sentenceBeanList,
				secondHandSpecialCustomList,
				crowdfundingCustomList,
				dynamicsCustomList));
	}

}