package com.usedmarket.dao;

import com.usedmarket.entity.Store;

import java.util.List;

/**
 * Created by huangMP on 2016/11/27.
 * decription :
 */
public interface StoreDao {

    int insert(Store store);

    List<Store> findAll();
}