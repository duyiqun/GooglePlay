package com.qun.googleplay.utils;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import com.qun.googleplay.global.GooglePlay;
import com.qun.googleplay.ui.activity.ShowActivity;

import java.util.Random;


/**
 * Created by Qun on 2017/5/2.
 */

public class Utils {

    //这个是在主线程去更新ui,在没有上下文的环境,
    public static void runOnUIThread(Runnable runnable) {
        GooglePlay.sMainHandler.post(runnable);
    }

    //得到字符串数组信息
    public static String[] getStringArray(int resId) {
        //getResources:R
        return getResources().getStringArray(resId);
    }

    //得到资源管理的类
    public static Resources getResources() {
        return GooglePlay.sContext.getResources();
    }

    //在屏幕适配时候使用,让代码中使用dip属性
    public static int getDimens(int resId) {
        return getResources().getDimensionPixelSize(resId);
    }

    //得到颜色
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**
     * 拿到一个随机颜色
     *
     * @return
     */
    public static int createRandomColor() {
        Random random = new Random();
        return random.nextInt(180);
    }

    // 创建一个随机的颜色
    public static int randomColor() {
        Random random = new Random();
        int red = random.nextInt(180);
        int blue = random.nextInt(180);
        int green = random.nextInt(180);
        System.out.println(red + ":" + blue + ":" + green);
        return Color.rgb(red, green, blue);
        // return 0;
    }

    //启动fragment
    public static void startFragment(Class clss, Bundle bundle) {
        Intent intent = new Intent(GooglePlay.sContext, ShowActivity.class);
        intent.putExtra(Fields.ShowActivity.CLASSNAME, clss);
        intent.putExtra(Fields.ShowActivity.BUNDLE, bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        GooglePlay.sContext.startActivity(intent);
    }
}
