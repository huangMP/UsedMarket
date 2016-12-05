package com.usedmarket.controller.web;

import com.usedmarket.controller.BaseController;
import com.usedmarket.dto.HttpResult;
import com.usedmarket.dto.QueryCondition;
import com.usedmarket.entity.Crowdfunding;
import com.usedmarket.service.AttachmentService;
import com.usedmarket.service.CrowdfundingService;
import com.usedmarket.util.NarrowImage;
import com.usedmarket.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by huangMP on 2016/11/26.
 * decription : Controller
 */
@Controller
@RequestMapping("/WebCrowdfunding")
public class WebCrowdfundingController extends BaseController{

    @Autowired
    CrowdfundingService crowdfundingService;
    @Autowired
    AttachmentService attachmentService;

    @RequestMapping(value = "/insert")
    @ResponseBody
    public HttpResult insert(
                      @RequestParam(value = "images") MultipartFile[] images,
                      @RequestParam(value = "crowdfundingType", defaultValue = "0") int crowdfundingType,
                      String title,
                      String description,
                      String origin,
                      @RequestParam(value = "targetAmount", defaultValue = "0") double targetAmount,
                      @RequestParam(value = "nowAmount", defaultValue = "0") int nowAmount,
                      @RequestParam(value = "supportNum", defaultValue = "0") int supportNum ){
        Crowdfunding crowdfunding = new Crowdfunding();
        crowdfunding.setCrowdfundingId(UuidUtil.get32UUID());
        crowdfunding.setCrowdfundingType(crowdfundingType);
        crowdfunding.setTitle(title);
        crowdfunding.setDescription(description);
        crowdfunding.setOrigin(origin);
        crowdfunding.setTargetAmount(targetAmount);
        crowdfunding.setSupportNum(supportNum);
        crowdfunding.setAddDate(new Date());

        //添加添加人
        //crowdfunding.setAddUser();

        if (!images[0].isEmpty()) {
            for (MultipartFile image : images) {
                //执行上传
                attachmentService.insert(image, crowdfunding.getCrowdfundingId(), "1" , NarrowImage.normalNarrowTarget);
            }
        }
        return getFrequentlyUsedReturnResultByBool(crowdfundingService.insert(crowdfunding));
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public HttpResult update(Crowdfunding crowdfunding) {
        return getFrequentlyUsedReturnResultByBool(crowdfundingService.update(crowdfunding));
    }

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
