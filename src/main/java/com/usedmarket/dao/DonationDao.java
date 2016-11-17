package com.usedmarket.dao;


import com.usedmarket.dto.DonationCustom;
import com.usedmarket.dto.DonationQueryCondition;
import com.usedmarket.entity.Attachment;
import com.usedmarket.entity.Donation;

import java.util.List;

/**
 * Created by huangMP on 2016/11/10.
 * decription :
 */
public interface DonationDao {

    /**
     * @param donationId
     * @return
     */
    DonationCustom findDonationCustomByDonationId(String donationId);
    /**
     * 插入一条信息
     * @param donation
     * @return 插入成功的数量
     */
    int insert(Donation donation) ;
    /**
     * 按要求查找
     * @param donationQueryCondition
     * @return
     */
    List<DonationCustom> findDonationByQueryCondition(DonationQueryCondition donationQueryCondition);

    /**
     * 读取图片
     * @param donationCustom 需要其中的commodityId
     * @return
     */
    List<Attachment> loadImages(List<DonationCustom> donationCustom);

    /**
     * @param donation
     * @return 返回成功更新数据条数
     */
    int update(Donation donation);
}
