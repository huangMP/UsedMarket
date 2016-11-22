package com.usedmarket.dto;

import com.usedmarket.entity.UserInfo;

/**
 * Created by huangMP on 2016/10/30.
 * decription :
 */
public class UserInfoCustom extends UserInfo {

    /**
     * 头像原图
     */
    private String headPortraitPath;
    /**
     * 头像压缩图
     */
    private String narrowHeadPortraitPath;
    /**
     * 角色名称
     */
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getHeadPortraitPath() {
        return headPortraitPath;
    }

    public void setHeadPortraitPath(String headPortraitPath) {
        this.headPortraitPath = headPortraitPath;
    }

    public String getNarrowHeadPortraitPath() {
        return narrowHeadPortraitPath;
    }

    public void setNarrowHeadPortraitPath(String narrowHeadPortraitPath) {
        this.narrowHeadPortraitPath = narrowHeadPortraitPath;
    }

    @Override
    public String toString() {
        return "UserInfoCustom{" +
                "headPortraitPath='" + headPortraitPath + '\'' +
                ", narrowHeadPortraitPath='" + narrowHeadPortraitPath + '\'' +
                "} " + super.toString();
    }
}
