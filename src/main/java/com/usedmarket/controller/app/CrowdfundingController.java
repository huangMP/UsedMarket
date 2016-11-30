package com.usedmarket.controller.app;

import com.usedmarket.controller.BaseController;
import com.usedmarket.dto.HttpResult;
import com.usedmarket.dto.QueryCondition;
import com.usedmarket.service.CrowdfundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huangMP on 2016/11/26.
 * decription : Controller
 */
@Controller
@RequestMapping("/Crowdfunding")
public class CrowdfundingController extends BaseController{

    @Autowired
    CrowdfundingService crowdfundingService;

    @RequestMapping(value = "/delete")
    @ResponseBody
    public HttpResult delete(String crowdfundingId) {
        return getFrequentlyUsedReturnResultByBool(crowdfundingService.delete(crowdfundingId));
    }

    @RequestMapping(value = "/findByQueryCondition")
    @ResponseBody
    public HttpResult findByQueryCondition(QueryCondition queryCondition){
        return getHttpResult(this.OPERATION_SUCCESS,crowdfundingService.findByQueryCondition(queryCondition) );
    }
}
