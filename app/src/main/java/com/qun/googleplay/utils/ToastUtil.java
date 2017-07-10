package com.qun.googleplay.utils;

import android.widget.Toast;

import com.qun.googleplay.global.GooglePlay;

public class ToastUtil {

    private static Toast toast;

    /**
     * 强大的吐司，能够连续弹的吐司
     *
     * @param text
     */
    public static void showToast(final String text) {

        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                if (toast == null) {
                    toast = Toast.makeText(GooglePlay.sContext, text, Toast.LENGTH_SHORT);
                } else {
                    toast.setText(text);//如果不为空，则直接改变当前toast的文本
                }
                toast.show();
            }
        });
    }
}
