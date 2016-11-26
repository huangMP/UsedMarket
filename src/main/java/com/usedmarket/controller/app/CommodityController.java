package com.usedmarket.controller.app;

import com.usedmarket.dto.CommodityCustom;
import com.usedmarket.dto.CommodityQueryCondition;
import com.usedmarket.dto.HttpResult;
import com.usedmarket.entity.Commodity;
import com.usedmarket.service.AttachmentService;
import com.usedmarket.service.CommodityService;
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
 * Description：商品的控制器
 * Created by Peivxuan on 2016/10/24.
 */

@Controller
@RequestMapping("/Commodity")
public class CommodityController {

	@Autowired
	CommodityService commodityService;

	@Autowired
	AttachmentService attachmentService;

	@RequestMapping(value = "/search")
	@ResponseBody
	public HttpResult searchCommodityByCondition(CommodityQueryCondition commodityQueryCondition) {
		return new HttpResult<List<CommodityCustom>>(commodityService.findCommodityByQueryCondition(commodityQueryCondition));
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public HttpResult deleteCommodity(String commodityId) {
		HttpResult httpResult = new HttpResult();
		if (commodityService.deleteByCommodityId(commodityId)) {
			httpResult.setResultCenter("删除成功");
		} else
			httpResult.setResultCenter("操作失败");
		return httpResult;
	}

	@RequestMapping(value = "/updateCommodityNum")
	@ResponseBody
	public HttpResult updateNumByCommodityId(Commodity commodity) {
		HttpResult httpResult = new HttpResult();
		if (commodityService.updateNumByCommodityId(commodity)) {
			httpResult.setResultCenter("更新成功");
		} else
			httpResult.setResultCenter("操作失败");
		return httpResult;
	}

	@RequestMapping(value = "/upload")
	@ResponseBody
	public HttpResult uploadCommodity(@RequestParam(value = "images") MultipartFile[] images,
	                              String userId,
	                              String storeId,
	                              String commodityName,
	                              String category,
	                              @RequestParam(value = "price", defaultValue = "0") double price,
	                              @RequestParam(value = "amount", defaultValue = "0") int amount,
	                              String description,
	                              String location,
	                              @RequestParam(value = "status", defaultValue = "0") int status) {
		Commodity commodity = new Commodity(
				UuidUtil.get32UUID(),
				userId,
				storeId,
				commodityName,
				category,
				price,
				amount,
				description,
				location,
				0,
				new Date(),
				0,
				status
		);

		if (!images[0].isEmpty()) {
			for (MultipartFile image : images) {
				//执行上传
				attachmentService.insert(image, commodity.getCommodityId(), "1");
			}

		}

		HttpResult httpResult = new HttpResult();

		if (commodityService.addCommodity(commodity)) {
			httpResult.setResultCenter("上传成功");
		} else
			httpResult.setResultCenter("操作失败");
		return httpResult;

	}

}
