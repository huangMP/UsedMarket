package com.usedmarket.dao;

import com.usedmarket.entity.Attachment;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 附件表 Dao
 */
public interface AttachmentDao {
    /**
     * 插入一条信息
     *
     * @param attachment
     * @return 插入成功的数量
     */
    public int insert(Attachment attachment);

    /**
     * 查找通过attachmentId
     *
     * @param attachmentId
     * @return
     */
    public Attachment findByAttachmentId(String attachmentId);


    /**
     * 修改一条信息
     *
     * @param attachment
     * @return 成功修改的信息条数
     */
    public int update(Attachment attachment);

    /**
     * 删除一条信息
     *
     * @param attachmentId
     * @return 成功删除的信息条数
     */
    public int delete(String attachmentId);

}
