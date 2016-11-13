package com.usedmarket.service.impl;

import com.usedmarket.dao.DonationDao;
import com.usedmarket.dto.DonationCustom;
import com.usedmarket.dto.DonationQueryCondition;
import com.usedmarket.entity.Attachment;
import com.usedmarket.entity.Donation;
import com.usedmarket.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 捐赠物品信息 Service层实现
 */
@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    DonationDao donationDao;

    /**
     * 插入一条信息
     * @param donation
     * @return 插入成功的数量
     */
    @Override
    public int insertDonation(Donation donation) {
        return donationDao.insert(donation);
    }

    /**
     * 按要求查找
     * @param donationQueryCondition
     * @return
     */
    @Override
    public List<DonationCustom> findDonationByQueryCondition(DonationQueryCondition donationQueryCondition) {

        //取出10条commodity
        List<DonationCustom> donationCustoms = donationDao.findDonationByQueryCondition(donationQueryCondition);

        if (donationCustoms.size() == 0) {
            return donationCustoms;
        }

        System.out.println("找到捐赠物品条目:"+donationCustoms.size());

        List<Attachment> attachments = donationDao.loadImages(donationCustoms);
        System.out.println("总的图片数量:" + attachments.size() );

        for( int i=0;i<donationCustoms.size();i++ ){
            List<String> imageList = new ArrayList<String>();
            List<String> narrowimageList = new ArrayList<String>();
            for(int j=0;j<attachments.size();j++){
                if( donationCustoms.get(i).getDonationId().equals( attachments.get(j).getContentId() ) ){
                    imageList.add( attachments.get(j).getFilePath() );
                    narrowimageList.add( attachments.get(j).getNarrowImagePath() );
                }
            }
            donationCustoms.get(i).setDonationImgs( imageList );
            donationCustoms.get(i).setNarrowDonationImgs( narrowimageList );
        }

        return donationCustoms;
    }
}
