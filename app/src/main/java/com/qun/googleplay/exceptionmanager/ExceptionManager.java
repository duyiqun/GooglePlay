package com.qun.googleplay.exceptionmanager;

import com.qun.googleplay.utils.ToastUtil;

/**
 * 异常管理类
 * Created by Qun on 2017/7/18.
 */

public class ExceptionManager {

    private ExceptionManager() {

    }

    private static ExceptionManager sExceptionManager = new ExceptionManager();

    public static ExceptionManager getInstance() {
        return sExceptionManager;
    }

    public void ShowException(Exception e) {
        if (e instanceof ExceptionA) {
            ToastUtil.showToast("异常A");
        }
        if (e instanceof ExceptionB) {
            ToastUtil.showToast("异常B");
        }
        if (e instanceof ExceptionC) {
            ToastUtil.showToast("异常C");
        }
        if (e instanceof ExceptionD) {
            ToastUtil.showToast("异常D");
        }
    }
}
