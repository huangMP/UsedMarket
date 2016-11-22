package com.usedmarket.dao;

import com.usedmarket.entity.Role;

import java.util.List;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 用户信息 Dao
 */
public interface RoleDao {
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
