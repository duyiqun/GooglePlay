package com.qun.googleplay.cachemanager;

/**
 * 缓存管理类
 * Created by Qun on 2017/5/2.
 */

class CacheManager {

    private static CacheManager sCacheManager = new CacheManager();

    private CacheManager() {
    }

    public static CacheManager getInstance() {
        return sCacheManager;
    }

    //传入url返回对应的数据
    public String getCacheData(String url) {

        return "";
    }

    //保存对应的数据
    public void saveCacheData(String url, String content) {


    }
}
