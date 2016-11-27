package com.usedmarket.controller.app;

import com.usedmarket.dto.CrowdfundingCustom;
import com.usedmarket.dto.CrowdfundingQueryCondition;
import com.usedmarket.dto.HttpResult;
import com.usedmarket.service.CrowdfundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by huangMP on 2016/11/26.
 * decription : Controller
 */
@Controller
@RequestMapping("/Crowdfunding")
public class CrowdfundingController{

    @Autowired
    CrowdfundingService crowdfundingService;

    @RequestMapping(value = "/delete")
    @ResponseBody
    public int delete(String crowdfundingId) {
        return crowdfundingService.delete(crowdfundingId);
    }

    @RequestMapping(value = "/findCrowdfundingQueryCondition")
    @ResponseBody
    public HttpResult findCrowdfundingQueryCondition(CrowdfundingQueryCondition crowdfundingQueryCondition){
        return new HttpResult<List<CrowdfundingCustom>>( crowdfundingService.findCrowdfundingQueryCondition(crowdfundingQueryCondition) );
    }
}
