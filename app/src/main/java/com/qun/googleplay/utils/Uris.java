package com.qun.googleplay.utils;

/**
 * Created by Qun on 2017/7/9.
 */

public class Uris {

    //主机地址
    public static final String HOST_ADDRESS = "http://127.0.0.1:8090";

    //home列表地址
    public static final String HOME_ADDRESS = HOST_ADDRESS + "/home?index=";

    //专题
    public static final String SUBJECT_ADDRESS = HOST_ADDRESS + "/subject?index=";

    //图片地址
    public static final String IMAGE_HOST = HOST_ADDRESS + "/image?name=";

    //关键字
    public static final String RECOMMEND_ADDRESS = HOST_ADDRESS + "/recommend?index=0";

    //分类地址
    public static final String CATEFORY_URL = HOST_ADDRESS + "/category?index=0";

    //热门地址
    public static final String HOT_ADDRESS = HOST_ADDRESS + "/hot?index=0";

    //详情的地址
    public static final String DETAIL_ADDRESS = HOST_ADDRESS + "/detail?packageName=";
}
