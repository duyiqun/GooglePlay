package com.qun.googleplay.cachemanager;

import android.text.TextUtils;

import com.qun.googleplay.utils.GsonUtil;

/**
 * 缓存框架
 * Created by Qun on 2017/5/2.
 */

public class JsonCacheManager {

    private static JsonCacheManager sJsonCacheManager = new JsonCacheManager();

    private JsonCacheManager() {
    }

    public static JsonCacheManager getInstance() {
        return sJsonCacheManager;
    }

    //用户传入地址跟对应的bean返回一个对象
    //当前的方法在哪里调用ctrl+B
    public Object getDataBean(String url, Class clss) {
        /**
         * 1. 去网络请求最新数据
         * 2. 如果没有数据去请求缓存数据
         */
        String content = NetManager.getInstance().dataGet(url);

        if (TextUtils.isEmpty(content)) {
            //空
            //缓存拿数据
            content = CacheManager.getInstance().getCacheData(url);
        } else {
            //非空
            //缓存数据
            CacheManager.getInstance().saveCacheData(url, content);
        }

        //去解析数据
        if (TextUtils.isEmpty(content)) {
            return null;
        } else {
            return GsonUtil.parseJsonToBean(content, clss);
        }
    }
}
