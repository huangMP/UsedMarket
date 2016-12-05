package com.usedmarket.service.impl;

import com.usedmarket.dao.RoleDao;
import com.usedmarket.dto.QueryCondition;
import com.usedmarket.entity.Role;
import com.usedmarket.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangMP on 2016/11/22.
 * decription : 角色信息 Service层实现
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public boolean insert(com.usedmarket.entity.Role role) {
        return 1 == roleDao.insert(role) ? true : false ;
    }

    @Override
    public com.usedmarket.entity.Role findByRoleName(String roleName) {
        return roleDao.findByRoleName(roleName);
    }

    @Override
    public com.usedmarket.entity.Role findByRoleId(String roleId) {
        return roleDao.findByRoleId(roleId);
    }

    @Override
    public List<com.usedmarket.entity.Role> findByStatus(String status) {
        return roleDao.findByStatus(status);
    }

    @Override
    public boolean update(Role role) {
        return 1 == roleDao.update(role) ? true : false ;
    }

    @Override
    public boolean delete(String roleId) {
        return 1 == roleDao.delete(roleId) ? true : false ;
    }

    /**
     * 按条件查找
     * @param queryCondition
     * @return
     */
    public List<Role> findByQueryCondition(QueryCondition queryCondition){
        return roleDao.findByQueryCondition(queryCondition);
    }
}
