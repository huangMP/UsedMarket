package com.usedmarket.dto;

import com.usedmarket.entity.SecondHandSpecial;

/**
 * Created by huangMP on 2016/11/27.
 * decription :
 */
public class SecondHandSpecialCustom extends SecondHandSpecial{

    private String imagePath;
    private String narrowImagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getNarrowImagePath() {
        return narrowImagePath;
    }

    public void setNarrowImagePath(String narrowImagePath) {
        this.narrowImagePath = narrowImagePath;
    }

    @Override
    public String toString() {
        return "SecondHandSpecialCustom{" +
                "imagePath='" + imagePath + '\'' +
                ", narrowImagePath='" + narrowImagePath + '\'' +
                "} " + super.toString();
    }
}
