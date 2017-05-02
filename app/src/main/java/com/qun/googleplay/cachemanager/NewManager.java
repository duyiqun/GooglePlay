package com.qun.googleplay.cachemanager;

/**
 * 统一网络管理类
 * Created by Qun on 2017/5/2.
 */

public class NewManager {

    private static NewManager sNewManager = new NewManager();

    private NewManager() {
    }

    public static NewManager getInstance() {
        return sNewManager;
    }

    //根据网络地址返回数据
    public String dataGet(String url) {

        return "";
    }
}
