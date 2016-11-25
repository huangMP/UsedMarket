package com.usedmarket.controller;

import com.usedmarket.entity.UserCollection;
import com.usedmarket.service.UserCollectionService;
import com.usedmarket.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description：收藏的controller
 * Created by Peivxuan on 2016/11/16.
 */
@Controller
@RequestMapping("/Collection")
public class UserCollectionController {

	@Autowired
	UserCollectionService userCollectionService;

	@RequestMapping(value = "/add")
	@ResponseBody
	public String addCollection(UserCollection userCollection) {
		userCollection.setCollectionId(UuidUtil.get32UUID());
		if (userCollectionService.findOneCollection(userCollection) == null) {
			if (userCollectionService.addCollection(userCollection)) {
				return "收藏成功";
			} else {
				return "操作失败";
			}
		} else {
			return "已收藏成功";
		}
	}

	@RequestMapping(value = "/remove")
	@ResponseBody
	public String removeOneCollection(UserCollection userCollection) {
		if (userCollectionService.removeOneCollection(userCollection)) {
			return "删除成功";
		} else {
			return "操作失败";
		}
	}

}
