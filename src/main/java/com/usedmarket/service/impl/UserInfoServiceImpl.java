package com.usedmarket.service.impl;

import com.usedmarket.dao.UserInfoDao;
import com.usedmarket.dto.UserInfoCustom;
import com.usedmarket.entity.UserInfo;
import com.usedmarket.service.UserInfoService;
import com.usedmarket.util.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
     * 按列修改
     *
     * @param userId
     * @param index
     * @param currentValue
     * @param futureValue
     * @return UserInfo
     */
    public UserInfoCustom update(String userId, String index, String currentValue, String futureValue) {

        UserInfoCustom userInfoCustom = findUserInfoCustomByUserId(userId);

        if( userInfoCustom == null ){
            return null;
        }
        System.out.println(userInfoCustom.toString());
        Map map = MapUtils.transBean2Map(userInfoCustom);

        if ("userId".equals(index) || "username".equals(index) || "attachmentId".equals(index) || "registrationDate".equals(index)) {
            System.out.println("此处不能修改 : " + index);
            return null;
        } else if ("password".equals(index) || "phone".equals(index) || "IDNum".equals(index) || "realName".equals(index)) {

            String currentValueInDatabase = (String) map.get(index);    //获取数据库保存的当前值
            if (null == currentValueInDatabase || "".equals(currentValueInDatabase)) {
                System.out.println("第一次添加 : " + index + ",无需验证");
                map.put(index, futureValue);
            } else if (currentValueInDatabase.equals(currentValue)) {
                System.out.println(index + "验证成功,修改为" + futureValue);
                map.put(index, futureValue);
            } else {
                System.out.println(index + "验证失败.");
                return null;
            }

        } else {
            System.out.println("修改 : " + index + ",无需验证");
            map.put(index, futureValue);
        }
        userInfoCustom = (UserInfoCustom) MapUtils.transMap2Bean(map, userInfoCustom);
        userInfoDao.update(userInfoCustom);
        System.out.println("修改完成");
        return userInfoCustom;
    }

    /**
     * 删除一条信息
     * @param userId
     * @return 成功删除的信息条数
     */
    public int delete(String userId) {
        return userInfoDao.delete(userId);
    }

    /**
     * 查找 UserInfoCustom 通过 username
     * @param username
     * @return UserInfoCustom
     */
    @Override
    public UserInfoCustom findUserInfoCustomByUsername(String username) {
        return userInfoDao.findUserInfoCustomByUsername(username);
    }

    /**
     * 查找 UserInfoCustom 通过 UserId
     * @param userId
     * @return UserInfoCustom
     */
    @Override
    public UserInfoCustom findUserInfoCustomByUserId(String userId) {
        return userInfoDao.findUserInfoCustomByUserId(userId);
    }
}
