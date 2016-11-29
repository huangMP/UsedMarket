package com.usedmarket.controller.web;

import com.usedmarket.controller.BaseController;
import com.usedmarket.dto.HttpResult;
import com.usedmarket.dto.QueryCondition;
import com.usedmarket.entity.Role;
import com.usedmarket.service.RoleService;
import com.usedmarket.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huangMP on 2016/11/22.
 * decription : 角色信息 controller
 */
@Controller
@RequestMapping("/WebRole")
public class WebRoleController extends BaseController{

    @Autowired
    RoleService roleService;

    /**
     * 插入一条信息
     * @param role
     * @return 插入成功的数量
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public HttpResult insert(Role role) {
        role.setRoleId(UuidUtil.get32UUID());
        if(1 == roleService.insert(role)){
            return getHttpResult("角色添加成功",role);
        }
        return getHttpResult("角色添加失败",role);
    }

    /**
     * 按条件查找
     * @param queryCondition
     * @return
     */
    @RequestMapping(value = "/findByQueryCondition")
    @ResponseBody
    public HttpResult findByQueryCondition(QueryCondition queryCondition){
        System.out.println(queryCondition.toString());
        return getHttpResult("查找完成",roleService.findByQueryCondition(queryCondition) );
    }



    /**
     * 修改
     * @param role
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public HttpResult update(Role role){
        if( 1 == roleService.update(role) ){
            return getHttpResult("更新完成",role);
        }
        return getHttpResult("更新失败",null);

    }

    /**
     * 删除一条信息
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public HttpResult delete(String roleId){
        if( 1 == roleService.delete(roleId) ){
            return getHttpResult("删除完成",null);
        }
        return getHttpResult("删除失败",null);
    }
}
