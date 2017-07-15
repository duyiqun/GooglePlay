package com.qun.googleplay.utils;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.qun.googleplay.R;
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

    //设置图片的方法
    public static void setNetImage(String url, ImageView view) {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) //显示图片加载中
                .showImageForEmptyUri(R.mipmap.ic_launcher) //空的图片
                .showImageOnFail(R.mipmap.ic_launcher) //错误的图片
                .cacheInMemory(true) //内存缓存要不要
                .cacheOnDisk(true) //sd卡缓存要不要
                .considerExifParams(true)//会识别图片的方向信息
                .displayer(new FadeInBitmapDisplayer(500)).build();//显示的效果
//        		.displayer(new RoundedBitmapDisplayer(36)).build();//圆形图片

        /**
         * 1.图片的地址
         * 2.图片的控件
         * 3.图片的设置
         */
        ImageLoader.getInstance().displayImage(url, view, options);
    }

    //设置圆形图片的方法
    public static void setNetRoundedImage(String url, ImageView view) {

        DisplayImageOptions roundedOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) //显示图片加载中
                .showImageForEmptyUri(R.mipmap.ic_launcher) //空的图片
                .showImageOnFail(R.mipmap.ic_launcher) //错误的图片
                .cacheInMemory(true) //内存缓存要不要
                .cacheOnDisk(true) //sd卡缓存要不要
                .considerExifParams(true)//会识别图片的方向信息
                .displayer(new FadeInBitmapDisplayer(500)).build();//显示的效果
//        		.displayer(new RoundedBitmapDisplayer(36)).build();//圆形图片

        /**
         * 1.图片的地址
         * 2.图片的控件
         * 3.图片的设置
         */
        ImageLoader.getInstance().displayImage(url, view, roundedOptions);
    }
}
