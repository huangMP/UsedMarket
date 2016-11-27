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
     * 绝对路劲
     */
    String fileAbsoluteathPath = ResourcesPath.attachmentAbsoluteathPath;
    /**
     * 相对路径
     */
    String fileRelativePath = ResourcesPath.attachmentRelativePath;

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

        //执行上传 返回真实文件名
        String fileName = FileUpload.fileUp(file, fileAbsoluteathPath, UuidUtil.get32UUID());
        //得到压缩图文件名
        String narrowImageFileName = "_" + fileName;
        //进行压缩
        NarrowImage.imageNarrow(fileAbsoluteathPath, narrowImageFileName, fileName, 5);

        attachment.setFilePath(fileRelativePath + fileName);
        attachment.setNarrowImagePath(fileRelativePath + narrowImageFileName);

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

        //得到当前的原图文件名
        String originalImageFileName = attachment.getFilePath().replaceAll(fileRelativePath, "");
        //得到当前的缩略图文件名
        String narrowImageFileName = attachment.getNarrowImagePath().replaceAll(fileRelativePath, "");
        //执行删除操作
        FileUtil.delFile(fileAbsoluteathPath.replaceAll("WEB-INF/classes/../../static/attachment/", "") + fileRelativePath + originalImageFileName);
        FileUtil.delFile(fileAbsoluteathPath.replaceAll("WEB-INF/classes/../../static/attachment/", "") + fileRelativePath + narrowImageFileName);

        //执行上传 返回真实文件名
        originalImageFileName = FileUpload.fileUp(file, fileAbsoluteathPath, UuidUtil.get32UUID());
        //得到压缩图文件名
        narrowImageFileName = "_" + originalImageFileName;
        //进行压缩
        NarrowImage.imageNarrow(fileAbsoluteathPath, narrowImageFileName, originalImageFileName, 5);

        attachment.setFilePath(fileRelativePath + originalImageFileName);
        attachment.setNarrowImagePath(fileRelativePath + narrowImageFileName);

        return attachmentDao.update(attachment);
    }

    /**
     * 删除一条信息
     *
     * @param attachmentId
     * @return 成功删除的信息条数
     */
    public int delete(String attachmentId) {
        Attachment attachment = findByAttachmentId(attachmentId);        //得到当前的原图文件名
        String originalImageFileName = attachment.getFilePath().replaceAll(fileRelativePath, "");
        //得到当前的缩略图文件名
        String narrowImageFileName = attachment.getNarrowImagePath().replaceAll(fileRelativePath, "");
        //执行删除操作
        FileUtil.delFile(fileAbsoluteathPath.replaceAll("WEB-INF/classes/../../static/attachment/", "") + fileRelativePath + originalImageFileName);
        FileUtil.delFile(fileAbsoluteathPath.replaceAll("WEB-INF/classes/../../static/attachment/", "") + fileRelativePath + narrowImageFileName);

        return attachmentDao.delete(attachmentId);
    }

    /**
     * 删除一条信息
     *
     * @param contentId
     * @return 成功删除的信息条数
     */
    public int deleteByContentId(String contentId){
        System.out.println("service"+contentId);
        Attachment attachment = attachmentDao.findByContentId(contentId).get(0);        //得到当前的原图文件名
        if(null == attachment){
            return 0;
        }
        String originalImageFileName = attachment.getFilePath().replaceAll(fileRelativePath, "");
        //得到当前的缩略图文件名
        String narrowImageFileName = attachment.getNarrowImagePath().replaceAll(fileRelativePath, "");
        //执行删除操作
        FileUtil.delFile(fileAbsoluteathPath.replaceAll("WEB-INF/classes/../../static/attachment/", "") + fileRelativePath + originalImageFileName);
        FileUtil.delFile(fileAbsoluteathPath.replaceAll("WEB-INF/classes/../../static/attachment/", "") + fileRelativePath + narrowImageFileName);

        return attachmentDao.deleteByContentId(contentId);
    }
}
