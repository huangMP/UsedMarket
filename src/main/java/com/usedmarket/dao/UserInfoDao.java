package com.usedmarket.dao;

import com.usedmarket.entity.UserInfo;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 用户信息 Dao
 */
public interface UserInfoDao {
    /**
     * 插入一条信息
     * @param userInfo
     * @return 插入成功的数量
     */
    public int insert(UserInfo userInfo) ;

    /**
     * 通过UserId查找UserInfo
     * @param userId
     * @return UserInfo
     */
    public UserInfo findByUserId(String userId) ;

    /**
     * 通过Username查找UserInfo
     * @param username
     * @return UserInfo
     */
    public UserInfo findByUsername(String username) ;

    /**
     * 修改用户信息
     * @param userInfo
     * @return 成功修改的信息条数
     */
    public int update(UserInfo userInfo);

    /**
     * 删除一条信息
     * @param userId
     * @return 成功删除的信息条数
     */
    public int delete(String userId);

}
