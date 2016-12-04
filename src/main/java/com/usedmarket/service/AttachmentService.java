package com.usedmarket.service;

import com.usedmarket.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 附件表的 Service层接口
 */
public interface AttachmentService {
    /**
     * 插入一条信息
     * @param file
     * @param fileType
     * @return attachmentId
     */
    String insert(MultipartFile file, String contentId,String fileType,int narrowTarget);

    /**
     * 查找通过attachmentId
     *
     * @param attachmentId
     * @return Attachment
     */
    Attachment findByAttachmentId(String attachmentId);

    /**
     * 修改
     * @param attachmentId
     * @param file
     * @return 成功修改的信息条数
     */
    int update(String attachmentId, MultipartFile file,int narrowTarget);

    /**
     * 删除一条信息
     *
     * @param attachmentId
     * @return 成功删除的信息条数
     */
    int delete(String attachmentId);

    /**
     * 删除一条信息
     *
     * @param contentId
     * @return 成功删除的信息条数
     */
    int deleteByContentId(String contentId);
}
