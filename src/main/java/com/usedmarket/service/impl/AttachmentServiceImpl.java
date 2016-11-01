package com.usedmarket.service.impl;

import com.usedmarket.dao.AttachmentDao;
import com.usedmarket.entity.Attachment;
import com.usedmarket.service.AttachmentService;
import com.usedmarket.util.*;
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
    public String insert(MultipartFile file, String contentId,String fileType) {

        Attachment attachment = new Attachment();
        attachment.setAttachmentId(UuidUtil.get32UUID());
        attachment.setFileType(fileType);
        attachment.setContentId(contentId);

        String fileAbsoluteathPath = ResourcesPath.attachmentAbsoluteathPath;
        String relativePath = ResourcesPath.attachmentRelativePath;

        //执行上传 返回真实文件名
        String fileName = FileUpload.fileUp(file, fileAbsoluteathPath, UuidUtil.get32UUID());
        //得到压缩图文件名
        String narrowImageFileName = "_" + fileName;
        //进行压缩
        NarrowImage.imageNarrow(fileAbsoluteathPath, narrowImageFileName, fileName, 5);

        attachment.setFilePath(relativePath + fileName);
        attachment.setNarrowImagePath(relativePath + narrowImageFileName);

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
     * @param attachmentId
     * @param file
     * @return 成功修改的信息条数
     */
    public int update(String attachmentId, MultipartFile file) {
        Attachment attachment = findByAttachmentId(attachmentId);

        String fileAbsoluteathPath = ResourcesPath.attachmentAbsoluteathPath;
        String relativePath = ResourcesPath.attachmentRelativePath;

        //得到当前的原图文件名
        String originalImageFileName = attachment.getFilePath().replaceAll(ResourcesPath.attachmentRelativePath, "");
        //得到当前的缩略图文件名
        String narrowImageFileName = attachment.getNarrowImagePath().replaceAll(ResourcesPath.attachmentRelativePath, "");
        //执行删除操作
        FileUtil.delFile(fileAbsoluteathPath.replaceAll("WEB-INF/classes/../../static/attachment/", "") + ResourcesPath.attachmentRelativePath + originalImageFileName);
        FileUtil.delFile(fileAbsoluteathPath.replaceAll("WEB-INF/classes/../../static/attachment/", "") + ResourcesPath.attachmentRelativePath + narrowImageFileName);

        //执行上传 返回真实文件名
        originalImageFileName = FileUpload.fileUp(file, fileAbsoluteathPath, UuidUtil.get32UUID());
        //得到压缩图文件名
        narrowImageFileName = "_" + originalImageFileName;
        //进行压缩
        NarrowImage.imageNarrow(fileAbsoluteathPath, narrowImageFileName, originalImageFileName, 5);

        attachment.setFilePath(relativePath + originalImageFileName);
        attachment.setNarrowImagePath(relativePath + narrowImageFileName);

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
