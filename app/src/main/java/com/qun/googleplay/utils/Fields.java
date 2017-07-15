package com.qun.googleplay.utils;

/**
 * 常量类
 * Created by Qun on 2017/7/14.
 */

public class Fields {
    public static final String PACKAGENAME = "PACKAGENAME";

    //当前的字段全是showactivity
    public static final class ShowActivity {
        //启动的类名
        public static final String CLASSNAME = "CLASSNAME";
        //传递的对象
        public static final String BUNDLE = "BUNDLE";
        //标题
        public static final String TITLE = "TITLE";
    }

    //图片类
    public static class ShowImagesFragment {
        //图片集合
        public static final String IMAGES = "IMAGES";
        //当前点击的点
        public static final String POINT = "POINT";
    }
}
