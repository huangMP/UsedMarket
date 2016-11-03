package com.usedmarket.dto;

import com.usedmarket.entity.Commodity;

/**
 * Description：自定义商品pojo
 * Created by Peivxuan on 2016/10/25.
 */
public class CommodityCustom extends Commodity {

    /**
     * 查询得到的二手商品数目
     */
    private String commodityNum;

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

    public String getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(String commodityNum) {
        this.commodityNum = commodityNum;
    }

    @Override
    public String toString() {
        return "CommodityCustom{" +
                "commodityNum='" + commodityNum + '\'' +
                ", username='" + username + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                "} " + super.toString();
    }
}
