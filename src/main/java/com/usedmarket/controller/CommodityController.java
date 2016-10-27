package com.usedmarket.controller;

import com.usedmarket.dto.CommodityCustom;
import com.usedmarket.dto.CommodityQueryCondition;
import com.usedmarket.entity.Commodity;
import com.usedmarket.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.usedmarket.util.*;

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
	                              String description) {
		Commodity commodity = new Commodity(
				UuidUtil.get32UUID(),
				userId,
				storeId,
				commodityName,
				category,
				price,
				amount,
				"",
				description,
				0,
				new Date(),
				0
		);

		if (images != null) {
			String imagesStr = "";

			for (MultipartFile image : images) {
				//执行上传 返回真实文件名
				String imageFileName = FileUpload.fileUp(image, ResourcesPath.commodityImagesAbsoluteath, UuidUtil.get32UUID());
				//得到压缩图文件名
				String narrowImageFileName = NarrowImage.getNarrowImageFileName(imageFileName);
				//进行压缩
				NarrowImage.imageNarrow(ResourcesPath.commodityImagesAbsoluteath, narrowImageFileName, imageFileName, 5);
				//设置头像真实文件名
				imagesStr += ResourcesPath.commodityImagesRelativePath + narrowImageFileName + ";";
			}

			commodity.setImages(imagesStr.substring(0, imagesStr.lastIndexOf(";")));
		}

		if (commodityService.addCommodity(commodity)) {
			return "商品上传成功";
		}

		return "商品上传失败";

	}

	@RequestMapping(value = "/searchByDescription")
	@ResponseBody
	public List<CommodityCustom> searchCommodityByNameAndDescription(String indistinctField) {
		return commodityService.findCommodityByNameAndDescription(indistinctField);
	}


}
