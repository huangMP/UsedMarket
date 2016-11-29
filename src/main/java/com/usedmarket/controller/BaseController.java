package com.usedmarket.controller;

import com.usedmarket.dto.HttpResult;

/**
 * Created by huangMP on 2016/11/29.
 * decription :
 */
public class BaseController {

    public <T> HttpResult getHttpResult(String resultCenter,T data) {
        HttpResult result = new HttpResult(resultCenter,data);
        return result;
    }


}
