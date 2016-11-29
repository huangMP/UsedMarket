package com.usedmarket.controller.app;

import com.usedmarket.dto.CommodityCategoryCustom;
import com.usedmarket.dto.HttpResult;
import com.usedmarket.dto.QueryCondition;
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
     * 按条件查找
     * @param queryCondition
     * @return
     */
    @RequestMapping(value = "/findByQueryCondition")
    @ResponseBody
    public HttpResult findByQueryCondition(QueryCondition queryCondition) {
        return new HttpResult<List<CommodityCategoryCustom>>(commodityCategoryService.findByQueryCondition(queryCondition));
    }


}
