package com.usedmarket.dao;

import com.usedmarket.dao.CommentDao;
import com.usedmarket.entity.Comment;
import com.usedmarket.util.UuidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by huangMP on 2016/10/22.
 * decription : CommentDaoTest 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class CommentDaoTest {

    @Autowired
    CommentDao commentDao;

    @Test
    public void testInsert() {
        Comment comment = new Comment();
        comment.setCommentDate(new Date());
        comment.setCommentId(UuidUtil.get32UUID());
        comment.setCommodityId("1");
        comment.setCrowdfundingId("1");
        commentDao.insert(comment);
        System.out.println(comment.toString());
    }

    @Test
    public void testFindByCommodityId() {
        List<Comment> commentList = commentDao.findByCommodityId("1");
        for( Comment comment: commentList ){
            System.out.println(comment.toString());
        }
    }

    @Test
    public void testFindByCrowdfundingId() {
        List<Comment> commentList = commentDao.findByCrowdfundingId("1");
        for( Comment comment: commentList ){
            System.out.println(comment.toString());
        }
    }

    @Test
    public void testFindByCommentId() {
        Comment comment = commentDao.findByCommentId("1");
        System.out.println(comment.toString());
    }



    @Test
    public void testUpdate() {
        Comment comment = commentDao.findByCommentId("1");
        comment.setCommentText("这是留言");
        commentDao.update(comment);
    }

    @Test
    public void testDelete() {
        int i = commentDao.deleteByCommentId("1");
        System.out.println("删除数量:"+i);
    }

    @Test
    public void testDeleteByCommodityId() {
        int i = commentDao.deleteByCommodityId("1");
        System.out.println("删除数量:"+i);
    }

    @Test
    public void testDeleteByCrowdfundingId() {
        int i = commentDao.deleteByCrowdfundingId("1");
        System.out.println("删除数量:"+i);
    }
}