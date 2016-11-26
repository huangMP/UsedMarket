package com.usedmarket.controller.app;

import com.usedmarket.dto.HttpResult;
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
	public HttpResult addCollection(UserCollection userCollection) {
		HttpResult httpResult = new HttpResult();
		userCollection.setCollectionId(UuidUtil.get32UUID());
		if (userCollectionService.findOneCollection(userCollection) == null) {
			if (userCollectionService.addCollection(userCollection)) {
				httpResult.setResultCenter("收藏成功");
			} else {
				httpResult.setResultCenter("操作失败");
			}
		} else {
			httpResult.setResultCenter("已收藏成功");
		}
		return httpResult;
	}

	@RequestMapping(value = "/remove")
	@ResponseBody
	public HttpResult removeOneCollection(UserCollection userCollection) {
		HttpResult httpResult = new HttpResult();
		if (userCollectionService.removeOneCollection(userCollection)) {
			httpResult.setResultCenter("删除成功");
		} else {
			httpResult.setResultCenter("操作失败");
		}
		return httpResult;
	}

}
