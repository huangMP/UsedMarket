package com.usedmarket.service.impl;

import com.usedmarket.dao.SecondHandSpecialDao;
import com.usedmarket.dto.SecondHandSpecialCustom;
import com.usedmarket.entity.SecondHandSpecial;
import com.usedmarket.service.SecondHandSpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangMP on 2016/11/24.
 * decription : Service层实现
 */
@Service
public class SecondHandSpecialServiceImpl implements SecondHandSpecialService {

    @Autowired
    SecondHandSpecialDao secondHandSpecialDao;

    @Override
    public int insert(SecondHandSpecial secondHandSpecial) {
        return secondHandSpecialDao.insert(secondHandSpecial);
    }

    @Override
    public int delete(String secondHandSpecialId) {
        return secondHandSpecialDao.delete(secondHandSpecialId);
    }

    @Override
    public SecondHandSpecial findBySecondHandSpecialId(String secondHandSpecialId) {
        return secondHandSpecialDao.findBySecondHandSpecialId(secondHandSpecialId);
    }

    @Override
    public SecondHandSpecialCustom findSecondHandSpecialCustomBySecondHandSpecialId(String secondHandSpecialId) {
        return secondHandSpecialDao.findSecondHandSpecialCustomBySecondHandSpecialId(secondHandSpecialId);
    }

    @Override
    public List<SecondHandSpecialCustom> findAll() {
        return secondHandSpecialDao.findAll();
    }

    @Override
    public int update(SecondHandSpecial secondHandSpecial) {
        return secondHandSpecialDao.update(secondHandSpecial);
    }
}
