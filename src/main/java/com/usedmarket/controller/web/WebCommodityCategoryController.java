package com.usedmarket.controller.web;

import com.usedmarket.dto.CommodityCategoryCustom;
import com.usedmarket.entity.CommodityCategory;
import com.usedmarket.service.AttachmentService;
import com.usedmarket.service.CommodityCategoryService;
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
 * Created by huangMP on 2016/11/24.
 * decription : controller
 */
@Controller
@RequestMapping("/WebCommodityCategory")
public class WebCommodityCategoryController {

    @Autowired
    CommodityCategoryService commodityCategoryService;
    @Autowired
    AttachmentService attachmentService;

    /**
     * @param
     * @return
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public boolean insert(
            @RequestParam(value="picture") MultipartFile picture,
            @RequestParam(value="commodityCategoryName") String commodityCategoryName,
            @RequestParam(value="sort",defaultValue = "0") int sort ) {
        CommodityCategory commodityCategory = new CommodityCategory();
        commodityCategory.setCommodityCategoryId(UuidUtil.get32UUID());
        commodityCategory.setAddDate(new Date());
        commodityCategory.setSort(sort);
        commodityCategory.setCommodityCategoryName(commodityCategoryName);
        //设置添加人 获取当前登录的用户
        //commodityCategory.setAddUserId();

        String attachmentId = attachmentService.insert(picture, commodityCategory.getCommodityCategoryId(), "3");
        commodityCategory.setAttachmentId(attachmentId);    //设置附件Id

        if( 1 == commodityCategoryService.insert(commodityCategory)){
            return true;
        }
        return false;
    }

    /**
     * @param commodityCategoryId
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public boolean delete(String commodityCategoryId) {
        attachmentService.deleteByContentId(commodityCategoryId);
        commodityCategoryService.delete(commodityCategoryId);
        return true;
    }

    /**
     * 查找分类通过 commodityCategoryId
     * @param commodityCategoryId
     * @return
     */
    @RequestMapping(value = "/findCommodityCategoryCustomByCommodityCategoryId")
    @ResponseBody
    public CommodityCategoryCustom findCommodityCategoryCustomByCommodityCategoryId(String commodityCategoryId) {
        return commodityCategoryService.findCommodityCategoryCustomByCommodityCategoryId(commodityCategoryId);
    }


    /**
     * 查找所有分类
     * @return
     */
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<CommodityCategoryCustom> findAll() {
        return commodityCategoryService.findAll();
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public boolean update(
            @RequestParam(value="commodityCategoryId") String commodityCategoryId,
            @RequestParam(value="picture") MultipartFile picture,
            @RequestParam(value="commodityCategoryName") String commodityCategoryName,
            @RequestParam(value="sort",defaultValue = "0") int sort ) {
        CommodityCategory commodityCategoryInDatabase = commodityCategoryService.findByCommodityCategoryId(commodityCategoryId);
        commodityCategoryInDatabase.setSort(sort);
        commodityCategoryInDatabase.setCommodityCategoryName(commodityCategoryName);

        if( 1 != attachmentService.deleteByContentId(commodityCategoryId)){
            return false;
        }
        String attachmentId = attachmentService.insert(picture, commodityCategoryInDatabase.getCommodityCategoryId(), "3");
        commodityCategoryInDatabase.setAttachmentId(attachmentId);    //设置附件Id

        if( 1 == commodityCategoryService.update(commodityCategoryInDatabase) ){
            return true;
        }
        return false;
    }


}
