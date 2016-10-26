package com.usedmarket.service.impl;

import com.usedmarket.dao.UserInfoDao;
import com.usedmarket.entity.UserInfo;
import com.usedmarket.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 用户信息 Service层实现
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    /**
     * 插入一条信息
     * @param userInfo
     * @return 插入成功的数量
     */
    public int insertUserInfo(UserInfo userInfo) {
        return userInfoDao.insert( userInfo );
    }

    /**
     * 通过UserId查找UserInfo
     * @param userId
     * @return UserInfo
     */
    public UserInfo findByUserId(String userId) {
        return userInfoDao.findByUserId(userId);
    }

    /**
     * 通过Username查找UserInfo
     * @param username
     * @return UserInfo
     */
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @return 成功修改的信息条数
     */
    public int updateUserInfo(UserInfo userInfo){
        return userInfoDao.update(userInfo);
    }

    /**
     * 删除一条信息
     * @param userId
     * @return 成功删除的信息条数
     */
    public int delete(String userId) {
        return userInfoDao.delete(userId);
    }
}
