package com.usedmarket.controller;

import com.google.gson.Gson;
import com.usedmarket.entity.UserInfo;
import com.usedmarket.service.AttachmentService;
import com.usedmarket.service.UserInfoService;
import com.usedmarket.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.UUIDEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 用户信息 controller
 */
@Controller
@RequestMapping("/UserInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    AttachmentService attachmentService;

    /**
     * 用户注册
     * @param headPortrait 头像（流）
     * @param username 用户名
     * @param password 密码
     * @param sex 性别
     * @param phone 手机
     * @return
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public String insertUserInfo(
            @RequestParam(value="headPortrait") MultipartFile headPortrait,
            @RequestParam(value="username") String username,
            @RequestParam(value="password") String password,
            @RequestParam(value = "sex", defaultValue = "9") int sex,
            @RequestParam(value="phone") String phone
                                 ) throws IOException {

        //判断接受到的信息是否正确
        if(
                ("".equals(password.trim()) || null == password) ||
                        ("".equals(username.trim()) || null == username) ||
                        ("".equals(phone.trim()) || null == phone) ||
                        (sex != 0 && sex != 1) ||
                        (headPortrait == null || headPortrait.isEmpty())
                ){
            System.out.println("接收到的信息不完全");
            return "注册失败";
        }

        //通过用户名向数据库查询UserInfo
        UserInfo userInfoInDatabase = userInfoService.findByUsername( username.trim() );

        //如果该用户名已存在
        if( null != userInfoInDatabase ){
            System.out.println("用户已存在");
            return "注册失败";
        }

        UserInfo userInfo = new UserInfo();
        //设置UUID主键
        userInfo.setUserId( UuidUtil.get32UUID() );
        //设置用户名
        userInfo.setUsername(username);
        //设置密码
        userInfo.setPassword( password.trim() );
        //设置性别
        userInfo.setSex(sex);
        //设置手机
        userInfo.setPhone(phone);
        //设置时间
        userInfo.setRegistrationDate(new Date());

        String attachmentId = attachmentService.insert(headPortrait, "0");
        userInfo.setHeadPortrait(attachmentId);

        //向数据库添加一条用户信息
        userInfoService.insertUserInfo( userInfo );
        System.out.println("注册成功");
        return "注册成功";
    }

    /**
     * 用户登录
     * @param userInfo //用户名：username  密码：password
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(UserInfo userInfo) {

        //判断接受到的信息是否正确
        if (
                null == userInfo.getUsername().trim() || "".equals(userInfo.getUsername().trim()) ||
                        null == userInfo.getPassword().trim() || "".equals(userInfo.getPassword().trim())
                ) {
            System.out.println("接收到的信息不完全");
            return "登录失败";
        }

        //通过用户名向数据库查询UserInfo
        UserInfo userInfoInDatabase = userInfoService.findByUsername( userInfo.getUsername().trim() );

        //判断该用户是否存在
        if( null == userInfoInDatabase ){
            System.out.println("该用户不存在");
            return "登录失败";
        }

        //判断密码是否输入正确
        if( userInfoInDatabase.getPassword().trim().equals( userInfo.getPassword().trim() ) ){
            System.out.println("登录成功");
            return JsonUtil.toJson(userInfoInDatabase);
        }
        System.out.println("密码不正确");
        return "登录失败";
    }

    /**
     * 修改密码
     * @param userInfo //用户Id：userId  密码：password  新密码：newPassword
     * @return
     */
    @RequestMapping(value = "/editPassword")
    @ResponseBody
    public String editPassword(UserInfo userInfo, String newPassword) {

        //判断接受到的信息是否正确
        if(
                null == userInfo.getUserId().trim() || "".equals(userInfo.getUserId().trim()) ||
                        null == userInfo.getPassword().trim() || "".equals(userInfo.getPassword().trim()) ||
                null == newPassword.trim() || "".equals( newPassword.trim() )
                ){
            System.out.println("接收到的信息不完全");
            return "修改失败";
        }

        //通过用户Id向数据库查询UserInfo
        UserInfo userInfoInDatabase = userInfoService.findByUserId(userInfo.getUserId().trim());

        //判断该用户是否存在
        if( null == userInfoInDatabase ){
            System.out.println("该用户不存在");
            return "修改失败";
        }

        if( userInfoInDatabase.getPassword().trim().equals( userInfo.getPassword().trim() ) ){
            System.out.println("认证成功");
            userInfoInDatabase.setPassword( userInfo.getPassword().trim() );
            //设置密码
            userInfoInDatabase.setPassword( newPassword.trim() );
            //保存到数据库
            userInfoService.updateUserInfo( userInfoInDatabase );
            return JsonUtil.toJson(userInfoInDatabase);
        }
        System.out.println("密码不正确");
        return "修改失败";
    }

    /**
     * 修改头像
     *
     * @param headPortrait //用户Id：userId  头像：headPortrait
     * @return
     */
    @RequestMapping(value = "/editHeadPortrait")
    @ResponseBody
    public String editHeadPortrait(
            @RequestParam(value = "headPortrait") MultipartFile headPortrait,
            @RequestParam(value = "userId") String userId
    ) {

        //判断接受到的信息是否正确
        if (
                ("".equals(userId.trim()) || null == userId) ||
                        (headPortrait == null || headPortrait.isEmpty())
                ) {
            System.out.println("接收到的信息不完全");
            return "修改失败";
        }

        //通过用户Id向数据库查询UserInfo
        UserInfo userInfoInDatabase = userInfoService.findByUserId(userId.trim());

        //判断该用户是否存在
        if (null == userInfoInDatabase) {
            System.out.println("该用户不存在");
            return "修改失败";
        }

        attachmentService.update(userInfoInDatabase.getHeadPortrait(), headPortrait);

        //保存到数据库
        userInfoService.updateUserInfo(userInfoInDatabase);

        return "修改成功";
    }

}
