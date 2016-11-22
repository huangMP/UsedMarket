package com.usedmarket.controller.web;

import com.usedmarket.entity.Role;
import com.usedmarket.service.RoleService;
import com.usedmarket.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by huangMP on 2016/11/22.
 * decription : 角色信息 controller
 */
@Controller
@RequestMapping("/WebRole")
public class WebRoleController {

    @Autowired
    RoleService roleService;

    /**
     * 插入一条信息
     * @param role
     * @return 插入成功的数量
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public Role insert(Role role) {
        role.setRoleId(UuidUtil.get32UUID());
        if(1 == roleService.insert(role)){
            System.out.println("角色添加成功");
            return role;
        }
        System.out.println("角色添加失败");
        return null;
    }

    /**
     * 通过roleName查找
     * @param roleName
     * @return
     */
    @RequestMapping(value = "/findByRoleName")
    @ResponseBody
    public Role findByRoleName(String roleName) {
        return roleService.findByRoleName(roleName);
    }

    /**
     * 查找
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/findByRoleId")
    @ResponseBody
    public Role findByRoleId(String roleId) {
        return roleService.findByRoleId(roleId);
    }

    /**
     * 通过status查找
     * @param status
     * @return
     */
    @RequestMapping(value = "/findByStatus")
    @ResponseBody
    List<Role> findByStatus(String status) {
        return roleService.findByStatus(status);
    }

    /**
     * 修改
     * @param role
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Role update(Role role){
        if( 1 == roleService.update(role) ){
            return role;
        }
        return null;

    }

    /**
     * 删除一条信息
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public boolean delete(String roleId){
        if( 1 == roleService.delete(roleId) ){
            return true;
        }
        return false;
    }
}
