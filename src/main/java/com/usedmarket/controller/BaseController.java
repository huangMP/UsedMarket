package com.usedmarket.controller;

import com.usedmarket.dto.HttpResult;
import com.usedmarket.util.UuidUtil;

/**
 * Created by huangMP on 2016/11/29.
 * decription :
 */
public class BaseController {

    protected static final String OPERATION_SUCCESS = "操作成功";

    protected static final String OPERATION_FAILED = "操作失败";

    protected  static final String OPERATION_REPETITION = "操作重复";

    protected  <T> HttpResult getHttpResult(String resultCenter,T data) {
        return new HttpResult<T>(resultCenter,data);
    }

    protected String get32UUID() {
        return UuidUtil.get32UUID();
    }

    protected HttpResult getFrequentlyUsedReturnResultByBool(Boolean b) {
       return b ?
        this.getHttpResult(BaseController.OPERATION_SUCCESS,"") : this.getHttpResult(BaseController.OPERATION_FAILED,"");
    }

}
