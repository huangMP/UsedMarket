package com.usedmarket.controller.web;

import com.usedmarket.controller.BaseController;
import com.usedmarket.dto.HttpResult;
import com.usedmarket.dto.QueryCondition;
import com.usedmarket.entity.Dynamics;
import com.usedmarket.service.DynamicsService;
import com.usedmarket.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by huangMP on 2016/11/18.
 * decription : 动态信息 controller
 */
@Controller
@RequestMapping("/WebDynamics")
public class WebDynamicsController extends BaseController{

    @Autowired
    DynamicsService dynamicsService;

    /**
     * 跳转到新增动态页面
     * @return Dynamics
     */
    @RequestMapping(value = "/toInsertSchool")
    @ResponseBody
    public ModelAndView toInsertSchool(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("schooldynamics/schooldynamics_add");
        return getModelAndView("schooldynamics/schooldynamics_add" ,"", null);
    }

    /**
     * 跳转到修改动态页面
     * @return Dynamics
     */
    @RequestMapping(value = "/toEditSchool")
    @ResponseBody
    public ModelAndView toEditSchool( String dynamicsId ){
        Dynamics dynamics = dynamicsService.findByDynamicsId(dynamicsId);
        if(null != dynamics){
            return getModelAndView("schooldynamics/schooldynamics_edit" ,"dynamics", dynamics);
        }
        return null;
    }

    /**
     * 新增动态
     * @param dynamics
     * @return Dynamics
     */
    @RequestMapping(value = "/insertSchool")
    @ResponseBody
    public Dynamics insertSchool(Dynamics dynamics){
        dynamics.setDynamicsId( UuidUtil.get32UUID() );
        dynamics.setType( 1 );
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
    @RequestMapping(value = "/displaySchool")
    @ResponseBody
    public ModelAndView displaySchool(String dynamicsId){
        Dynamics dynamics = dynamicsService.findByDynamicsId(dynamicsId);
        if(null != dynamics){
            return getModelAndView("schooldynamics/schooldynamics_display" ,"dynamics", dynamics);
        }
        return null;
    }

    /**
     * 跳转到新增动态页面
     * @return Dynamics
     */
    @RequestMapping(value = "/toInsertDonation")
    @ResponseBody
    public ModelAndView toInsertDonation(){
        return getModelAndView("donationdynamics/donationdynamics_add" ,"", null);
    }

    /**
     * 跳转到修改动态页面
     * @return Dynamics
     */
    @RequestMapping(value = "/toEditDonation")
    @ResponseBody
    public ModelAndView toEditDonation( String dynamicsId ){
        Dynamics dynamics = dynamicsService.findByDynamicsId(dynamicsId);
        if(null != dynamics){
            return getModelAndView("donationdynamics/donationdynamics_edit" ,"dynamics", dynamics);
        }
        return null;
    }

    /**
     * 新增动态
     * @param dynamics
     * @return Dynamics
     */
    @RequestMapping(value = "/insertDonation")
    @ResponseBody
    public Dynamics insertDonation(Dynamics dynamics){
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
    @RequestMapping(value = "/displayDonation")
    @ResponseBody
    public ModelAndView displayDonation(String dynamicsId){
        Dynamics dynamics = dynamicsService.findByDynamicsId(dynamicsId);
        if(null != dynamics){
            return getModelAndView("donationdynamics/donationdynamics_display" ,"dynamics", dynamics);
        }
        return null;
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

    /**
     * 按条件查找
     * @param queryCondition
     * @return
     */
    @RequestMapping(value = "/findDynamicsByQueryCondition")
    @ResponseBody
    public HttpResult findDynamicsByQueryCondition(QueryCondition queryCondition) {
        return getHttpResult("查找完成",dynamicsService.findDynamicsByQueryCondition(queryCondition));
    }

    /**
     * 创建modelAndView、填充数据、设置视图
     * @param viewName
     * @param objectKey
     * @param objectValue
     * @return
     */
    ModelAndView getModelAndView(String viewName, String objectKey, Dynamics objectValue){
        ModelAndView modelAndView = new ModelAndView();
        if( !"".equals(objectKey) ){
            modelAndView.addObject(objectKey, objectValue);
        }
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
