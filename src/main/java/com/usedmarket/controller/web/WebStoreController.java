package com.usedmarket.controller.web;

import com.usedmarket.dto.HttpResult;
import com.usedmarket.entity.Store;
import com.usedmarket.service.AttachmentService;
import com.usedmarket.service.StoreService;
import com.usedmarket.util.NarrowImage;
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
@RequestMapping("/WebStore")
public class WebStoreController {

    @Autowired
    StoreService storeService;
    @Autowired
    AttachmentService attachmentService;

    @RequestMapping(value = "/insert")
    @ResponseBody
    public int insert(
            @RequestParam(value = "images") MultipartFile[] images,
            String storeName,
            String description) {

        Store store = new Store();
        store.setStoreName(storeName);
        store.setDescription(description);
        store.setRegistrationDate(new Date());

        store.setPreferNum("0");
        store.setSalesVolume("0");
        store.setStoreId(UuidUtil.get32UUID());

        //设置添加人
        //

        if (!images[0].isEmpty()) {
            for (MultipartFile image : images) {
                //执行上传
                attachmentService.insert(image, store.getStoreId(), "5" , NarrowImage.normalNarrowTarget);
            }
        }

        return storeService.insert(store);
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public HttpResult findAll(){
        return new HttpResult<List<Store>>(storeService.findAll());
    }
}
