package com.usedmarket.controller;

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
	public List<Commodity> searchCommodityByCondition(CommodityQueryCondition commodityQueryCondition) {
		return commodityService.findCommodityByQueryCondition(commodityQueryCondition);
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String deleteCommodity(int commodityId) {
		if (commodityService.deleteByCommodityId(commodityId)) {
			return "删除成功";
		}
		return "操作失败";
	}

	@RequestMapping(value = "/upload")
	@ResponseBody
	public String uploadCommodity(@RequestParam(value="images") MultipartFile[] images,
	                            String userId, String storeId, String commodityName,
	                            String category, double price, int amount, String description){
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
				//头像存放路径
				String filePath = ResourcesPath.commodityImagesAbsoluteath+ "static/commodityImages";
				//执行上传 返回真实文件名
				String imageFileName = FileUpload.fileUp(image, filePath, UuidUtil.get32UUID() );
				//设置头像真实文件名
				imagesStr += ResourcesPath.commodityImagesRelativePath + imageFileName + ",";
			}

			commodity.setImages(imagesStr.substring(0, imagesStr.lastIndexOf(",")));
		}

		commodityService.addCommodity(commodity);

		return "操作成功：" + commodity.getImages();

	}

}
