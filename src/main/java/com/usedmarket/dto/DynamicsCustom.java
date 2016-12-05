package com.usedmarket.dto;

import com.usedmarket.entity.Attachment;
import com.usedmarket.entity.Dynamics;

import java.util.List;

/**
 * Created by huangMP on 2016/11/19.
 * decription :
 */
public class DynamicsCustom extends Dynamics{

    /**
     * 添加人姓名
     */
    private String username;
    /**
     * 添加人头像
     */
    private String headPortrait;

    /**
     * 图片集合
     * @return
     */
    private List<Attachment> images;

    public List<Attachment> getImages() {
        return images;
    }

    public void setImages(List<Attachment> images) {
        this.images = images;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    @Override
    public String toString() {
        return "DynamicsCustom{" +
                "username='" + username + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", images='" + images + '\'' +
                "} " + super.toString();
    }
}
