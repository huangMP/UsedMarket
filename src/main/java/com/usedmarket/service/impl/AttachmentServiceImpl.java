package com.usedmarket.service.impl;

import com.usedmarket.dao.AttachmentDao;
import com.usedmarket.entity.Attachment;
import com.usedmarket.service.AttachmentService;
import com.usedmarket.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by huangMP on 2016/10/22.
 * decription : 用户信息 Service层实现
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentDao attachmentDao;

    /**
     * 插入一条信息
     *
     * @param file
     * @return attachmentId
     */
    public String insert(MultipartFile file, String fileType) {

        Attachment attachment = new Attachment();
        attachment.setAttachmentId(UuidUtil.get32UUID());

        //fileType，不同类型不同处理
        //fileType == 0 ,即该附件是用户头像
        if ("0" == fileType) {

        } else if ("0" == fileType) {

        }
/*
        //执行上传 返回真实文件名
        String headPortraitFileName = FileUpload.fileUp(headPortrait, ResourcesPath.headPortraitAbsoluteath , UuidUtil.get32UUID() );
        //得到压缩图文件名
        String narrowImageFileName = NarrowImage.getNarrowImageFileName(headPortraitFileName);
        //进行压缩
        NarrowImage.imageNarrow(ResourcesPath.headPortraitAbsoluteath, narrowImageFileName, headPortraitFileName, 5);

        //设置保存路径  (保存压缩图路径)
        userInfo.setHeadPortrait(ResourcesPath.headPortraitRelativePath + narrowImageFileName);

*/

        attachmentDao.insert(attachment);

        return attachment.getAttachmentId();
    }

    /**
     * 查找通过attachmentId
     *
     * @param attachmentId
     * @return Attachment
     */
    public Attachment findByAttachmentId(String attachmentId) {
        return attachmentDao.findByAttachmentId(attachmentId);
    }

    /**
     * 修改
     *
     * @param attachment
     * @return 成功修改的信息条数
     */
    public int update(Attachment attachment) {
        return attachmentDao.update(attachment);
    }

    /**
     * 删除一条信息
     *
     * @param attachmentId
     * @return 成功删除的信息条数
     */
    public int delete(String attachmentId) {
        return attachmentDao.delete(attachmentId);
    }
}
