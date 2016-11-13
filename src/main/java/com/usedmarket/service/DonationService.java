package com.usedmarket.service;

import com.usedmarket.dto.DonationCustom;
import com.usedmarket.dto.DonationQueryCondition;
import com.usedmarket.entity.Donation;

import java.util.List;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 捐赠物品信息的 Service层接口
 */
public interface DonationService {
    /**
     * 插入一条信息
     * @param donation
     * @return 插入成功的数量
     */
    public int insertDonation(Donation donation) ;

    /**
     * 按要求查找
     * @param donationQueryCondition
     * @return
     */
    List<DonationCustom> findDonationByQueryCondition(DonationQueryCondition donationQueryCondition);
}
