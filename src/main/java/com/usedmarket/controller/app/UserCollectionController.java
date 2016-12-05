package com.usedmarket.controller.app;

import com.usedmarket.controller.BaseController;
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
public class UserCollectionController extends BaseController{

	@Autowired
	UserCollectionService userCollectionService;

	@RequestMapping(value = "/add")
	@ResponseBody
	public HttpResult addCollection(UserCollection userCollection) {
		userCollection.setCollectionId(this.get32UUID());
		if (userCollectionService.findOneCollection(userCollection) == null)
			return this.getFrequentlyUsedReturnResultByBool(userCollectionService.addCollection(userCollection));
		else
			return this.getHttpResult(BaseController.OPERATION_REPETITION,"");
	}

	@RequestMapping(value = "/remove")
	@ResponseBody
	public HttpResult removeOneCollection(UserCollection userCollection) {
		return this.getFrequentlyUsedReturnResultByBool(userCollectionService.removeOneCollection(userCollection));
	}

}
