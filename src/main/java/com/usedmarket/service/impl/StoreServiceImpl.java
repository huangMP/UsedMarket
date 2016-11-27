package com.usedmarket.service.impl;

import com.usedmarket.dao.StoreDao;
import com.usedmarket.entity.Store;
import com.usedmarket.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangMP on 2016/11/27.
 * decription :
 */
@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreDao storeDao;

    @Override
    public int insert(Store store) {
        return storeDao.insert(store);
    }

    @Override
    public List<Store> findAll() {
        return storeDao.findAll();
    }
}
