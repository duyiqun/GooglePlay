package com.qun.googleplay.cachemanager;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 统一网络管理类
 * Created by Qun on 2017/5/2.
 */

public class NetManager {

    private static NetManager sNetManager = new NetManager();

    private NetManager() {
    }

    public static NetManager getInstance() {
        return sNetManager;
    }

    //根据网络地址返回数据
    public String dataGet(String url) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;//处理异常
        }
    }
}
