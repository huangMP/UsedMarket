package com.usedmarket.dao;

import com.usedmarket.entity.Role;
import com.usedmarket.util.UuidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by huangMP on 2016/11/21.
 * decription : RoleDao 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class RoleDaoTest {

    @Autowired
    RoleDao roleDao;

    @Test
    public void testInsert() {
        Role role = new Role();
        role.setRoleId(UuidUtil.get32UUID());
        role.setRoleName("appuser");
        role.setRoleRealName("app用户");
        role.setStatus("1");
        roleDao.insert(role);
        System.out.println("操作完成");
    }

    @Test
    public void testFindByRoleId() {
        Role role = roleDao.findByRoleId("922324647d68435d9b01117b8c6b01bb");
        System.out.println(role.toString());
        System.out.println("操作完成");
    }

    @Test
    public void testFindByRoleName() {
        Role role = roleDao.findByRoleName("admin");
        System.out.println(role.toString());
        System.out.println("操作完成");
    }

    @Test
    public void testUpdate() {
        Role role = roleDao.findByRoleId("3a8ef70ddf3e4a44b0db4d793231d003");
        role.setRoleRealName("管理校园动态人员");
        roleDao.update(role);
        System.out.println("操作完成");
    }

    @Test
    public void testDelete() {
        roleDao.delete("0acb60fcf4934371b972c651f40d6c6d");
        System.out.println("操作完成");
    }

    @Test
    public void testfindByStatus(){
        List<Role> list = roleDao.findByStatus("1");
        for(Role r : list){
            System.out.println(r.toString());
        }
        System.out.println("操作完成");

    }
}