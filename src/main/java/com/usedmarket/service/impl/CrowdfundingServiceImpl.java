package com.usedmarket.service.impl;

import com.usedmarket.dao.CrowdfundingDao;
import com.usedmarket.dto.CrowdfundingCustom;
import com.usedmarket.dto.CrowdfundingQueryCondition;
import com.usedmarket.entity.Attachment;
import com.usedmarket.entity.Crowdfunding;
import com.usedmarket.service.CrowdfundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangMP on 2016/11/24.
 * decription : Service层实现
 */
@Service
public class CrowdfundingServiceImpl implements CrowdfundingService {

    @Autowired
    CrowdfundingDao crowdfundingDao;

    @Override
    public int insert(Crowdfunding crowdfunding) {
        return crowdfundingDao.insert(crowdfunding);
    }

    @Override
    public Crowdfunding findByCrowdfundingId(String crowdfundingId) {
        return crowdfundingDao.findByCrowdfundingId(crowdfundingId);
    }

    @Override
    public Crowdfunding findByaddUser(String addUser) {
        return crowdfundingDao.findByaddUser(addUser);
    }

    @Override
    public int update(Crowdfunding crowdfunding) {
        return crowdfundingDao.update(crowdfunding);
    }

    @Override
    public int delete(String crowdfundingId) {
        return crowdfundingDao.delete(crowdfundingId);
    }

    /**
     * 按条件查询
     * @param crowdfundingQueryCondition
     * @return
     */
    public List<CrowdfundingCustom> findCrowdfundingQueryCondition(CrowdfundingQueryCondition crowdfundingQueryCondition){

        List<CrowdfundingCustom> crowdfundingCustoms = crowdfundingDao.findCrowdfundingQueryCondition(crowdfundingQueryCondition);

        if (crowdfundingCustoms.size() == 0) {
            return null;
        }

        System.out.println("找到捐赠物品条目:"+crowdfundingCustoms.size());

        List<Attachment> attachments = crowdfundingDao.loadImages(crowdfundingCustoms);
        System.out.println("总的图片数量:" + attachments.size() );

        for( int i=0;i<crowdfundingCustoms.size();i++ ){
            List<String> imageList = new ArrayList<String>();
            List<String> narrowimageList = new ArrayList<String>();
            for(int j=0;j<attachments.size();j++){
                System.out.println(attachments.get(j).getContentId());
                if( crowdfundingCustoms.get(i).getCrowdfundingId().equals( attachments.get(j).getContentId() ) ){
                    System.out.println(attachments.get(j).getContentId());
                    imageList.add( attachments.get(j).getFilePath() );
                    narrowimageList.add( attachments.get(j).getNarrowImagePath() );
                }
            }
            crowdfundingCustoms.get(i).setImgs( imageList );
            crowdfundingCustoms.get(i).setNarrowImgs( narrowimageList );
        }

        return crowdfundingCustoms;
    }
}
