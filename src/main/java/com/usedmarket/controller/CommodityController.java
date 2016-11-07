package com.usedmarket.controller;

import com.usedmarket.dto.CommodityCustom;
import com.usedmarket.dto.CommodityQueryCondition;
import com.usedmarket.entity.Commodity;
import com.usedmarket.service.AttachmentService;
import com.usedmarket.service.CommodityService;
import com.usedmarket.util.FileUpload;
import com.usedmarket.util.NarrowImage;
import com.usedmarket.util.ResourcesPath;
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
	public List<CommodityCustom> searchCommodityByCondition(CommodityQueryCondition commodityQueryCondition) {
		return commodityService.findCommodityByQueryCondition(commodityQueryCondition);
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String deleteCommodity(String commodityId) {
		if (commodityService.deleteByCommodityId(commodityId)) {
			return "删除成功";
		}
		return "操作失败";
	}

	@RequestMapping(value = "/upload")
	@ResponseBody
	public String uploadCommodity(@RequestParam(value = "images") MultipartFile[] images,
	                              String userId,
	                              String storeId,
	                              String commodityName,
	                              String category,
	                              @RequestParam(value = "price", defaultValue = "0") double price,
	                              @RequestParam(value = "amount", defaultValue = "0") int amount,
	                              String description,
	                              String location) {
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
				0
		);

		if (!images[0].isEmpty()) {
			for (MultipartFile image : images) {
				//执行上传
				attachmentService.insert(image, commodity.getCommodityId(), "1");
			}

		}

		if (commodityService.addCommodity(commodity)) {
			return "商品上传成功";
		}

		return "商品上传失败";

	}

}
