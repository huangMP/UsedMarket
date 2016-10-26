package com.usedmarket.dto;

import com.usedmarket.entity.Commodity;

/**
 * Description：自定义商品pojo
 * Created by Peivxuan on 2016/10/25.
 */
public class CommodityCustom extends Commodity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 头像
     */
    private String headPortrait;

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
        return "CommodityCustom{" +
                super.toString() +
                "username='" + username + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                '}';
    }
}
