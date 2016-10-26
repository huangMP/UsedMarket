package com.usedmarket.dao;


import com.usedmarket.entity.Crowdfunding;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 众筹表 Dao
 */
public interface CrowdfundingDao {
    /**
     * 插入一条信息
     * @param crowdfunding
     * @rturn 插入成功的数量
     */
    public int insert(Crowdfunding crowdfunding) ;

    /**
     * 查找通过crowdfundingId
     * @param crowdfundingId
     * @return UserInfo
     */
    public Crowdfunding findByCrowdfundingId(String crowdfundingId) ;

    /**
     * 通过Username查找UserInfo
     * @param addUser
     * @return UserInfo
     */
    public Crowdfunding findByaddUser(String addUser) ;

    /**
     * 修改用户信息
     * @param crowdfunding
     * @return 成功修改的信息条数
     */
    public int update(Crowdfunding crowdfunding);

    /**
     * 删除一条信息
     * @param crowdfundingId
     * @return 成功删除的信息条数
     */
    public int delete(String crowdfundingId);

}
