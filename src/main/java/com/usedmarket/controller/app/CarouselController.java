package com.usedmarket.controller.app;

import com.usedmarket.dto.HttpResult;
import com.usedmarket.entity.Carousel;
import com.usedmarket.service.AttachmentService;
import com.usedmarket.service.CarouselService;
import com.usedmarket.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Description：轮播图Controller
 * Created by Peivxuan on 2016/11/26.
 */
@Controller
@RequestMapping("/Carousel")
public class CarouselController {

	@Autowired
	private CarouselService carouselService;

	@Autowired
	AttachmentService attachmentService;

	@RequestMapping(value = "/upload")
	@ResponseBody
	public HttpResult uploadCommodity(@RequestParam(value = "image") MultipartFile image, String title ) {
		Carousel carousel = new Carousel(
				UuidUtil.get32UUID(),
				title,
				new Date(),
				0
		);

		//暂时设置为空
		carousel.setAddUserId("test");

		HttpResult httpResult = new HttpResult();

		if (!image.isEmpty()) {
			attachmentService.insert(image, carousel.getCarouselId(), "3");
		} else {
			httpResult.setResultCenter("操作失败");
			return httpResult;
		}

		if (carouselService.insert(carousel)) {
			httpResult.setResultCenter("上传成功");
		} else
			httpResult.setResultCenter("操作失败");
		return httpResult;

	}

	@RequestMapping(value = "/top5")
	@ResponseBody
	public HttpResult selectTop5() {
		return new HttpResult<List<Carousel>> (carouselService.selectTop5());
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public HttpResult deleteByCarouselId(String carouselId) {

		HttpResult httpResult = new HttpResult();

		if (carouselService.deleteByCarouselId(carouselId)) {
			httpResult.setResultCenter("删除成功");
		} else
			httpResult.setResultCenter("操作失败");
		return httpResult;

	}

	@RequestMapping(value = "/update")
	@ResponseBody
	public HttpResult updateByCarouselId(Carousel carousel) {

		HttpResult httpResult = new HttpResult();

		if (carouselService.updateByCarouselId(carousel)) {
			httpResult.setResultCenter("更新成功");
		} else
			httpResult.setResultCenter("操作失败");
		return httpResult;

	}

}
