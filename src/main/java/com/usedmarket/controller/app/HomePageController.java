package com.usedmarket.controller.app;

import com.usedmarket.controller.BaseController;
import com.usedmarket.dto.*;
import com.usedmarket.entity.Carousel;
import com.usedmarket.entity.SentenceBean;
import com.usedmarket.entity.Store;
import com.usedmarket.entity.SubjectHead;
import com.usedmarket.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description：首页展示数据的controller
 * Created by Peivxuan on 2016/11/27.
 */
@Controller
@RequestMapping("/HomePage")
public class HomePageController extends BaseController{

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
	private CommodityCategoryService commodityCategoryService;

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

	/**
	 * 店铺
	 */
	@Autowired
	private StoreService storeService;

	/**
	 * 标题头
	 */
	@Autowired
	private SubjectHeadService subjectHeadService;

	@RequestMapping("/display")
	@ResponseBody
	public HttpResult HomePageDataDisplay(
			@RequestParam(value = "sentenceSize", defaultValue = "5") Integer sentenceSize,
			@RequestParam(value = "commodityCategorySize", defaultValue = "4") Integer commodityCategorySize,
			@RequestParam(value = "crowdfundinSize", defaultValue = "5")Integer crowdfundinSize,
			@RequestParam(value = "dynamicsSize", defaultValue = "5")Integer dynamicsSize) {
		//五条轮播图
		List<Carousel> carouselList = carouselService.selectTop5();
		//五条跑马条
		List<SentenceBean> sentenceBeanList = sentenceService.selectSentencesByCondition(new SentenceQueryCondition(1, 0, sentenceSize, false));
		//全部二手专题
		List<CommodityCategoryCustom> commoditycCategoryCustomList = commodityCategoryService.findByQueryCondition(new QueryCondition("type", "2", "", "DESC", "sort", 0, commodityCategorySize));
		//五条众筹
		List<CrowdfundingCustom> crowdfundingCustomList = crowdfundingService.findByQueryCondition(new QueryCondition("all", "", "", "DESC", "add_date", 0, crowdfundinSize));
		//五条动态
		List<DynamicsCustom> dynamicsCustomList = dynamicsService.findDynamicsByQueryCondition(new QueryCondition("all", "", "", "DESC", "add_date", 0,dynamicsSize));
		//店铺
		List<Store> storeList = storeService.findAll();
		//标题头
		List<SubjectHead> subjectHeadList = subjectHeadService.selectAll();

		return this.getHttpResult("", new HomePageData(
				carouselList,
				sentenceBeanList,
				commoditycCategoryCustomList,
				crowdfundingCustomList,
				dynamicsCustomList,
				storeList,
				subjectHeadList
		));
	}


}
