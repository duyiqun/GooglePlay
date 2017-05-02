package com.qun.googleplay.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Qun on 2017/5/2.
 */

public class GooglePlay extends Application {

    public static Handler mainHandler;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
