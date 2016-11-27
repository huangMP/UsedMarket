package com.usedmarket.controller.app;

import com.usedmarket.dto.SecondHandSpecialCustom;
import com.usedmarket.service.SecondHandSpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by huangMP on 2016/11/27.
 * decription :
 */
@Controller
@RequestMapping("/SecondHandSpecial")
public class SecondHandSpecialController {

    @Autowired
    SecondHandSpecialService secondHandSpecialService;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<SecondHandSpecialCustom> findAll() {
        return secondHandSpecialService.findAll();
    }

}
