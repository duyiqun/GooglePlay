package com.qun.googleplay.cachemanager;

import android.os.Environment;

import com.qun.googleplay.global.GooglePlay;

import java.io.File;
import java.io.FileOutputStream;

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
        //sd卡根目录包名
        try {
            String path = Environment.getExternalStorageDirectory().getPath() + File.separator + GooglePlay.context.getPackageName();
            //文件夹多级目录应该手动创建
            File pathDir = new File(path);

            //多级目录需要创建
            if (!pathDir.exists()) {
                pathDir.mkdirs();
            }

            File file = new File(pathDir, getFileName(url));

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getFileName(String url) {
        return "test";
    }
}
