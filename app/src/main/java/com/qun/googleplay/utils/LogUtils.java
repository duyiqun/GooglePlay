package com.qun.googleplay.utils;

import android.util.Log;

/**
 * 测试的时候 可以看到日志，正式的时候不可以看到日志信息
 * Created by Qun on 2017/7/18.
 */

public class LogUtils {

    public static final boolean isOpenLog = false;//关闭日志

    public void Logi(String message) {
        if (isOpenLog) {
            Log.i("我的日志", message);
        }
    }
}
