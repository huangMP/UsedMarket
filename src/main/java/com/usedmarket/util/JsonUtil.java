package com.usedmarket.util;


import com.google.gson.Gson;
import com.usedmarket.entity.UserInfo;

import java.util.Date;

/**
 * Created by huangMP on 2016/10/23.
 * decription : 转成Json格式
 */
public class JsonUtil {

    private static Gson gson = new Gson();

    public static String toJson(Object object){
        return gson.toJson(object);
    }

    public static void main(String args[]){
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword("jkljkjlkj");
        userInfo.setBirthday(new Date());
        System.out.println( JsonUtil.toJson( userInfo ) );
    }
}
