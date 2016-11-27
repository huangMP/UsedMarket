package com.usedmarket.controller.web;

import com.usedmarket.dto.HttpResult;
import com.usedmarket.dto.SecondHandSpecialCustom;
import com.usedmarket.entity.SecondHandSpecial;
import com.usedmarket.service.AttachmentService;
import com.usedmarket.service.SecondHandSpecialService;
import com.usedmarket.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Created by huangMP on 2016/11/27.
 * decription :
 */
@Controller
@RequestMapping("/WebSecondHandSpecial")
public class WebSecondHandSpecialController {

    @Autowired
    SecondHandSpecialService secondHandSpecialService;
    @Autowired
    AttachmentService attachementService;

    @RequestMapping(value = "/insert")
    @ResponseBody
    public HttpResult insert(
            @RequestParam(value = "images") MultipartFile[] images,
            @RequestParam(value = "secondHandSpecialName") String secondHandSpecialName,
            @RequestParam(value = "sort", defaultValue = "0") int sort ) {

        SecondHandSpecial secondHandSpecial =new SecondHandSpecial();
        secondHandSpecial.setSecondHandSpecialId(UuidUtil.get32UUID());
        secondHandSpecial.setAddDate(new Date());
        secondHandSpecial.setSecondHandSpecialName(secondHandSpecialName);
        secondHandSpecial.setSort(sort);

        //设置添加人
        //

        if (!images[0].isEmpty()) {
            for (MultipartFile image : images) {
                //执行上传
                attachementService.insert(image, secondHandSpecial.getSecondHandSpecialId() , "4");
            }
        }
        return new HttpResult<Integer>( secondHandSpecialService.insert(secondHandSpecial) );
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public HttpResult delete(String secondHandSpecialId) {
        return new HttpResult<Integer>( secondHandSpecialService.delete(secondHandSpecialId) );
    }

    @RequestMapping(value = "/findBySecondHandSpecialId")
    @ResponseBody
    public HttpResult findBySecondHandSpecialId(String secondHandSpecialId) {
        return new HttpResult<SecondHandSpecial>( secondHandSpecialService.findBySecondHandSpecialId(secondHandSpecialId) );
    }

    @RequestMapping(value = "/findSecondHandSpecialCustomBySecondHandSpecialId")
    @ResponseBody
    public HttpResult findSecondHandSpecialCustomBySecondHandSpecialId(String secondHandSpecialId) {
        return new HttpResult<SecondHandSpecialCustom>(secondHandSpecialService.findSecondHandSpecialCustomBySecondHandSpecialId(secondHandSpecialId) );
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public HttpResult findAll() {
        return new HttpResult<List<SecondHandSpecialCustom>>( secondHandSpecialService.findAll() );
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public HttpResult update(SecondHandSpecial secondHandSpecial) {
        return  new HttpResult<Integer>( secondHandSpecialService.update(secondHandSpecial) );
    }
}
