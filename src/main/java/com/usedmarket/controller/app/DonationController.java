package com.usedmarket.controller.app;

import com.usedmarket.dto.DonationCustom;
import com.usedmarket.dto.DonationQueryCondition;
import com.usedmarket.dto.HttpResult;
import com.usedmarket.entity.Donation;
import com.usedmarket.service.AttachmentService;
import com.usedmarket.service.DonationService;
import com.usedmarket.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 捐赠 controller
 */
@Controller
@RequestMapping("/Donation")
public class DonationController {

    @Autowired
    DonationService donationService;
    @Autowired
    AttachmentService attachmentService;

    /**
     * 上传捐赠
     * @param images 头像（流）
     * @param userId 用户名
     * @param donationName 捐赠名称
     * @param category 分类
     * @param amount 数量
     * @param location 定位
     * @param description 描述
     * @return
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public HttpResult insertUserInfo(@RequestParam(value = "images") MultipartFile[] images,
                                 String userId,
                                 String donationName,
                                 String category,
                                 @RequestParam(value = "amount", defaultValue = "1") int amount,
                                 String location,
                                 String description,
                                 String phone
    ) throws IOException {

        Donation donation = new Donation();
        donation.setDonationId(UuidUtil.get32UUID());
        donation.setUserId( userId );
        donation.setDonationName( donationName );
        donation.setCategory( category );
        donation.setAmount( amount );
        donation.setLocation( location );
        donation.setDescription( description );
        donation.setPhone( phone );
        donation.setStatus( 0 );
        donation.setDonationDate( new Date() );

        if (!images[0].isEmpty()) {
            for (MultipartFile image : images) {
                //执行上传
                attachmentService.insert(image, donation.getDonationId(), "2");
            }
        }

        HttpResult httpResult = new HttpResult();

        if( 0 != donationService.insertDonation(donation)){
            httpResult.setResultCenter("上传成功");
        } else
            httpResult.setResultCenter("操作失败");

        return httpResult;
    }


    /**
     * 按条件查找
     * @param donationQueryCondition
     * @return
     */
    @RequestMapping(value = "/search")
    @ResponseBody
    public HttpResult searchDonationQueryCondition(DonationQueryCondition donationQueryCondition) {
        return new HttpResult<List<DonationCustom>>(donationService.findDonationByQueryCondition(donationQueryCondition));
    }

    /**
     * 按条件修改
     * @param donationId
     * @param type 要修改的列
     * @param futrueValue 未来值
     * @return
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public HttpResult editByCondition(String donationId ,String type ,String futrueValue ,String currentValue ,boolean isCheck) {
        return new HttpResult<DonationCustom>(donationService.editByCondition(donationId ,type ,futrueValue , currentValue ,isCheck ));
    }

}
