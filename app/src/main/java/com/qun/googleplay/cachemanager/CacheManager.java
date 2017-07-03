package com.qun.googleplay.cachemanager;

import android.os.Environment;

import com.qun.googleplay.global.GooglePlay;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 缓存管理类
 * Created by Qun on 2017/5/2.
 */

class CacheManager {

    private static CacheManager sCacheManager = new CacheManager();
    private final String mPath;

    private CacheManager() {
        mPath = Environment.getExternalStorageDirectory().getPath() + File.separator + GooglePlay.context.getPackageName();
        //文件夹多级目录应该手动创建
        File pathDir = new File(mPath);

        //多级目录需要创建
        if (!pathDir.exists()) {
            pathDir.mkdirs();
        }
    }

    public static CacheManager getInstance() {
        return sCacheManager;
    }

    //传入url返回对应的数据
    public String getCacheData(String url) {

        StringBuffer stringBuffer = new StringBuffer();
        try {
            File file = new File(mPath, getFileName(url));
            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1) {
                stringBuffer.append(new String(buffer, 0, len));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    //保存对应的数据
    public void saveCacheData(String url, String content) {
        //sd卡根目录包名
        try {
//            String path = Environment.getExternalStorageDirectory().getPath() + File.separator + GooglePlay.context.getPackageName();
//            //文件夹多级目录应该手动创建
//            File pathDir = new File(path);
//
//            //多级目录需要创建
//            if (!pathDir.exists()) {
//                pathDir.mkdirs();
//            }

            File file = new File(mPath, getFileName(url));

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //返回文件名
    private String getFileName(String url) {
        StringBuffer stringBuffer = new StringBuffer();
        //MD5
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //加密
            messageDigest.update(url.getBytes());
            //得到加密后的数据
            byte[] bytes = messageDigest.digest();
            for (int i = 0; i < bytes.length; i++) {
//                System.out.println(Integer.toHexString(bytes[i] & 0xFF));
                stringBuffer.append(Integer.toHexString(bytes[i] & 0xFF));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
