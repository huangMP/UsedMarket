package com.usedmarket.service;

import com.usedmarket.entity.Role;

import java.util.List;

/**
 * Created by huangMP on 2016/11/22.
 * decription : 角色的 Service层接口
 */
public interface RoleService {
    /**
     * 插入一条信息
     * @param role
     * @return 插入成功的数量
     */
    int insert(Role role) ;

    /**
     * 通过roleName查找
     * @param roleName
     * @return
     */
    Role findByRoleName(String roleName) ;

    /**
     * 查找
     * @param roleId
     * @return
     */
    Role findByRoleId(String roleId) ;

    /**
     * 通过status查找
     * @param status
     * @return
     */
    List<Role> findByStatus(String status) ;

    /**
     * 修改用户信息
     * @param role
     * @return 成功修改的信息条数
     */
    int update(Role role);

    /**
     * 删除一条信息
     * @param roleId
     * @return 成功删除的信息条数
     */
    int delete(String roleId);
}
