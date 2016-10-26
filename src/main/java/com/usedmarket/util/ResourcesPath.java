package com.usedmarket.util;

/**
 * Created by huangMP on 2016/10/24.
 * decription : 静态资源路径
 */
public class ResourcesPath {

    /**
     * 头像存放的相对路径
     */
    final public static String headPortraitRelativePath =  "static/headportrait";

    /**
     * 头像存放的绝对路径
     */
    final public static String headPortraitAbsoluteath = PathUtil.getClasspath()+ headPortraitRelativePath;

    /**
     * 商品图片相对路径
     */
    final public static String commodityImagesRelativePath = "static/commodityImages";

    /**
     * 商品图片绝对路径
     */
    final public static String commodityImagesAbsoluteath = PathUtil.getClasspath()+ commodityImagesRelativePath;

}
