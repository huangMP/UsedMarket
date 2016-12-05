package com.usedmarket.controller.app;

import com.usedmarket.controller.BaseController;
import com.usedmarket.dto.HttpResult;
import com.usedmarket.dto.QueryCondition;
import com.usedmarket.entity.Dynamics;
import com.usedmarket.service.DynamicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huangMP on 2016/11/18.
 * decription : 动态信息 controller
 */
@Controller
@RequestMapping("/Dynamics")
public class DynamicsController extends BaseController{

    @Autowired
    DynamicsService dynamicsService;

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
     * 按条件查找
     * @param queryCondition
     * @return
     */
    @RequestMapping(value = "/findDynamicsByQueryCondition")
    @ResponseBody
    public HttpResult findDynamicsByQueryCondition(QueryCondition queryCondition) {
        return getHttpResult(this.OPERATION_SUCCESS,dynamicsService.findDynamicsByQueryCondition(queryCondition));
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
