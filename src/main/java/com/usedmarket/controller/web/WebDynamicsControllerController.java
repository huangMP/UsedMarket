package com.usedmarket.controller.web;

import com.usedmarket.dto.DynamicsCustom;
import com.usedmarket.dto.DynamicsQueryCondition;
import com.usedmarket.entity.Dynamics;
import com.usedmarket.service.DynamicsService;
import com.usedmarket.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by huangMP on 2016/11/18.
 * decription : 动态信息 controller
 */
@Controller
@RequestMapping("/WebDonationDynamics")
public class WebDynamicsControllerController {

    @Autowired
    DynamicsService dynamicsService;

    /**
     * 跳转到新增动态页面
     * @return Dynamics
     */
    @RequestMapping(value = "/toInsert")
    @ResponseBody
    public ModelAndView toInsert(){
        // 创建modelAndView准备填充数据、设置视图
        ModelAndView modelAndView = new ModelAndView();
        // 视图
        modelAndView.setViewName("donationdynamics/donationdynamics_add");
        return modelAndView;
    }

    /**
     * 跳转到修改动态页面
     * @return Dynamics
     */
    @RequestMapping(value = "/toEdit")
    @ResponseBody
    public ModelAndView toEdit( String dynamicsId ){
        Dynamics dynamics = dynamicsService.findByDynamicsId(dynamicsId);
        if(null != dynamics){

            // 创建modelAndView准备填充数据、设置视图
            ModelAndView modelAndView = new ModelAndView();
            // 填充数据
            modelAndView.addObject("dynamics", dynamics);
            // 视图
            modelAndView.setViewName("donationdynamics/donationdynamics_edit");
            return modelAndView;
        }
        return null;
    }

    /**
     * 新增动态
     * @param dynamics
     * @return Dynamics
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public Dynamics insert(Dynamics dynamics){
        dynamics.setDynamicsId( UuidUtil.get32UUID() );
        dynamics.setType( 2 );
        dynamics.setAddDate( new Date());
        if( 0 < dynamicsService.insert(dynamics)){
            return dynamics;
        }
        return null;
    }

    /**
     * 通过dynamicsId跳转到展示页面
     * @param dynamicsId
     * @return Dynamics
     */
    @RequestMapping(value = "/display")
    @ResponseBody
    public ModelAndView display(String dynamicsId){
        Dynamics dynamics = dynamicsService.findByDynamicsId(dynamicsId);
        if(null != dynamics){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("dynamics", dynamics);
            modelAndView.setViewName("donationdynamics/donationdynamics_display");
            return modelAndView;
        }
        return null;
    }

    /**
     * 按条件查找
     * @param dynamicsQueryCondition
     * @return
     */
    @RequestMapping(value = "/listForAndroid")
    @ResponseBody
    public List<DynamicsCustom> listForAndroid(DynamicsQueryCondition dynamicsQueryCondition) {
        return dynamicsService.findDynamicsByQueryCondition(dynamicsQueryCondition);
    }

    /**
     * 更新修改
     * @param dynamics
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Dynamics update(Dynamics dynamics) {
        return dynamicsService.update(dynamics);
    }
}
