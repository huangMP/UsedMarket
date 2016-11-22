package com.usedmarket.service.impl;

import com.usedmarket.dao.RoleDao;
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
    public int insert(com.usedmarket.entity.Role role) {
        return roleDao.insert(role);
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
    public int update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public int delete(String roleId) {
        return roleDao.delete(roleId);
    }
}
