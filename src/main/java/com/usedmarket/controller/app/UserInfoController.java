package com.usedmarket.controller.app;

import com.usedmarket.dto.CommodityCustom;
import com.usedmarket.dto.CommodityQueryCondition;
import com.usedmarket.dto.UserInfoCustom;
import com.usedmarket.entity.Role;
import com.usedmarket.entity.UserInfo;
import com.usedmarket.service.AttachmentService;
import com.usedmarket.service.CommodityService;
import com.usedmarket.service.RoleService;
import com.usedmarket.service.UserInfoService;
import com.usedmarket.util.JsonUtil;
import com.usedmarket.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 用户信息 controller
 */
@Controller
@RequestMapping("/UserInfo")
public class UserInfoController {

    @Autowired
    CommodityService commodityService;

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    AttachmentService attachmentService;
    @Autowired
    RoleService roleService;

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
        userInfo.setUserId(UuidUtil.get32UUID());    //设置UUID主键
        userInfo.setUsername(username);    //设置用户名
        userInfo.setPassword(password.trim());    //设置密码
        userInfo.setSex(sex);    //设置性别
        userInfo.setPhone(phone);    //设置手机
        userInfo.setRegistrationDate(new Date());    //设置时间

        Role role = roleService.findByRoleName( "appuser" );
        userInfo.setRoleId( role.getRoleId() );


        String attachmentId = attachmentService.insert(headPortrait, userInfo.getUserId(), "0");
        userInfo.setAttachmentId(attachmentId);    //设置附件Id

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
    public UserInfoCustom login(UserInfo userInfo) {

        //判断接受到的信息是否正确
        if (
                null == userInfo.getUsername().trim() || "".equals(userInfo.getUsername().trim()) ||
                        null == userInfo.getPassword().trim() || "".equals(userInfo.getPassword().trim())
                ) {
            System.out.println("接收到的信息不完全");
            return null;
        }

        //通过用户名向数据库查询UserInfo
        UserInfoCustom userInfoCustom = userInfoService.findUserInfoCustomByUsername(userInfo.getUsername().trim());

        //判断该用户是否存在
        if (null == userInfoCustom) {
            System.out.println("该用户不存在");
            return null;
        }

        //判断密码是否输入正确
        if (userInfoCustom.getPassword().trim().equals(userInfo.getPassword().trim())) {
            System.out.println("登录成功");
            return userInfoCustom;
        }
        System.out.println("密码不正确");
        return null;
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

        //更新附件路径
        attachmentService.update(userInfoInDatabase.getAttachmentId(), headPortrait);

        //保存到数据库
        userInfoService.updateUserInfo(userInfoInDatabase);

        return "修改成功";
    }

    /**
     * 按列修改 (修改头像不可用)
     *
     * @param userId 用户Id
     * @param index 修改的属性
     * @param currentValue 当前值
     * @param futureValue 未来值
     * @return UserInfo
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public UserInfoCustom edit(String userId, String index, String currentValue, String futureValue) {
        return userInfoService.update(userId.trim(), index.trim(), currentValue.trim(), futureValue.trim());
    }

    /**
     * 根据userId查询该用户上传的二手商品数量
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/findCommodityCustomByUserId")
    @ResponseBody
    public List<CommodityCustom> findCommodityCustomByUserId(String userId,int index) {
        CommodityQueryCondition commodityQueryCondition = new CommodityQueryCondition();
        commodityQueryCondition.setType("t_commodity.user_id");
        commodityQueryCondition.setIndex(index);
        commodityQueryCondition.setQueryValue(userId.trim());
        return commodityService.findCommodityByQueryCondition(commodityQueryCondition);
    }

    /**
     * 根据 userId 查找得到 UserInfoCustom
     *
     * @param userId
     * @return UserInfoCustom
     */
    @RequestMapping(value = "/findUserInfoCustomByUserId")
    @ResponseBody
    public UserInfoCustom findUserInfoCustomByUserId(String userId){
        return userInfoService.findUserInfoCustomByUserId(userId.trim());
    }

}
