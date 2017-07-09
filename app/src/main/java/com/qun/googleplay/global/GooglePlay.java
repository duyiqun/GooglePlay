package com.qun.googleplay.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Qun on 2017/5/2.
 */

public class GooglePlay extends Application {

    public static Handler sMainHandler;
    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sMainHandler = new Handler();
        sContext = this;

        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
    }
}
