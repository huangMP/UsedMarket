package com.usedmarket.entity;

import java.util.Date;

/**
 * Created by huangMP on 2016/10/23.
 * decription : 留言实体类
 */
public class Comment {
    /**
     * 主键
     */
    private String commentId;
    /**
     * 商品Id
     */
    private String commodityId;
    /**
     * 众筹Id
     */
    private String crowdfundingId;

    /**
     * 留言内容
     */
    private String commentText;

    /**
     * 添加时间
     */
    private Date commentDate;
    /**
     * 添加人
     */
    private String commentUser;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCrowdfundingId() {
        return crowdfundingId;
    }

    public void setCrowdfundingId(String crowdfundingId) {
        this.crowdfundingId = crowdfundingId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {

        this.commentUser = commentUser;
    }


    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", commodityId='" + commodityId + '\'' +
                ", crowdfundingId='" + crowdfundingId + '\'' +
                ", commentText='" + commentText + '\'' +
                ", commentDate=" + commentDate +
                ", commentUser='" + commentUser + '\'' +
                '}';
    }
}
