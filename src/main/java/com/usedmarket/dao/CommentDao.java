package com.usedmarket.dao;


import com.usedmarket.entity.Comment;

import java.util.List;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 留言 CommentDao
 */
public interface CommentDao {
    /**
     * 插入一条信息
     * @param comment
     * @return 插入成功的数量
     */
    public int insert(Comment comment) ;

    /**
     * 通过commodityId查找Comment
     * @param commodityId
     * @return List<Comment>
     */
    public List<Comment> findByCommodityId(String commodityId) ;

    /**
     * 通过crowdfundingId查找Comment
     * @param crowdfundingId
     * @return List<Comment>
     */
    public List<Comment> findByCrowdfundingId(String crowdfundingId) ;

    /**
     * 通过commentId查找Comment
     * @param commentId
     * @return Comment
     */
    public Comment findByCommentId(String commentId) ;

    /**
     * 修改用户信息
     * @param comment
     * @return 成功修改的信息条数
     */
    public int update(Comment comment);

    /**
     * 删除通过commentId
     * @param commentId
     * @return 成功删除的信息条数
     */
    public int deleteByCommentId(String commentId);

    /**
     * 删除通过commodityId
     * @param commodityId
     * @return 成功删除的信息条数
     */
    public int deleteByCommodityId(String commodityId) ;

    /**
     * 删除通过crowdfundingId
     * @param crowdfundingId
     * @return 成功删除的信息条数
     */
    public int deleteByCrowdfundingId(String crowdfundingId) ;

}
