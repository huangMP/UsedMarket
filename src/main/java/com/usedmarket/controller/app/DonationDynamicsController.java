package com.usedmarket.controller.app;

import com.usedmarket.dto.DynamicsCustom;
import com.usedmarket.dto.DynamicsQueryCondition;
import com.usedmarket.dto.HttpResult;
import com.usedmarket.entity.Dynamics;
import com.usedmarket.service.DynamicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by huangMP on 2016/11/18.
 * decription : 动态信息 controller
 */
@Controller
@RequestMapping("/DonationDynamics")
public class DonationDynamicsController {

    @Autowired
    DynamicsService dynamicsService;

    /**
     * 通过dynamicsId跳转到展示页面
     * @param dynamicsId
     * @return Dynamics
     */
    @RequestMapping(value = "/display")
    @ResponseBody
    public ModelAndView display(String dynamicsId){
        Dynamics dynamics = dynamicsService.findByDynamicsId(dynamicsId);
        if(null == dynamics){
            return null;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dynamics", dynamics);
        modelAndView.setViewName("donationdynamics/donationdynamics_display");
        return modelAndView;
    }

    /**
     * 按条件查找
     * @param dynamicsQueryCondition
     * @return
     */
    @RequestMapping(value = "/listForAndroid")
    @ResponseBody
    public HttpResult listForAndroid(DynamicsQueryCondition dynamicsQueryCondition) {
        return new HttpResult<List<DynamicsCustom>>(dynamicsService.findDynamicsByQueryCondition(dynamicsQueryCondition));
    }
}
