package com.qun.googleplay.bean;

import com.qun.googleplay.interfaces.HeadType;

/**
 * Created by Qun on 2017/7/12.
 */

public class CategoryHeadBean implements HeadType{

    public String title;

    public CategoryHeadBean(String title) {
        this.title = title;
    }
}
