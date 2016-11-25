package com.usedmarket.controller.app;

import com.usedmarket.entity.CommodityCategoryCustom;
import com.usedmarket.service.CommodityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by huangMP on 2016/11/24.
 * decription : controller
 */
@Controller
@RequestMapping("/CommodityCategory")
public class CommodityCategoryController {

    @Autowired
    CommodityCategoryService commodityCategoryService;

    /**
     * 查找所有分类
     * @return
     */
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<CommodityCategoryCustom> findAll() {
        return commodityCategoryService.findAll();
    }

}
