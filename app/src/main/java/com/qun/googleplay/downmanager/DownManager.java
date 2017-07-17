package com.qun.googleplay.downmanager;

import android.os.Environment;
import android.util.SparseArray;

import com.qun.googleplay.bean.DetailBean;
import com.qun.googleplay.global.GooglePlay;
import com.qun.googleplay.utils.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 下载的框架
 * Created by Qun on 2017/7/17.
 */

public class DownManager {

    public static String dirPath = Environment.getExternalStorageDirectory().getPath() + File.separator + GooglePlay.sContext.getPackageName() + File.separator + "downs";

    private DownManager() {
        File dirFile = new File(dirPath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();//创建多级目录
        }
    }

    private static DownManager sDownManager = new DownManager();

    public static DownManager getInstance() {
        return sDownManager;
    }

    //状态存储
    private SparseArray<DownInfo> mDownInfos = new SparseArray<>();

    //定义方法
    //下载方法
    public void down(DetailBean detailBean) {
        //空闲，暂停，出错
        //拿到对应的状态
        DownInfo downInfo = mDownInfos.get(detailBean.getId());
        if (downInfo == null) {
            downInfo = new DownInfo(detailBean);
            mDownInfos.put(detailBean.getId(), downInfo);
        }

        //下载
        //时刻注意当前的状态
        //加入线程池当前的状态是等待
        downInfo.downState = WAIT;//等待
        //发布
        updateState(downInfo);
        DownRunnable downRunnable = new DownRunnable(downInfo);
        ThreadPoolManager.getInstance().addRunnable(downRunnable);
    }

    //更新状态
    //用户主线程更新ui
    private void updateState(final DownInfo downInfo) {
        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                for (DownManager.onDownListener onDownListener : mOnDownListeners) {
                    onDownListener.publishState(downInfo);
                }
            }
        });
    }

    //创建下载的线程
    public class DownRunnable implements Runnable {

        private DownInfo mDownInfo;

        //得到downinfo信息
        public DownRunnable(DownInfo downInfo) {
            this.mDownInfo = downInfo;
        }

        //一运行把状态改成下载
        @Override
        public void run() {
            mDownInfo.downState = DOWNING;//下载状态
            updateState(mDownInfo);//发布状态

            //三种状态，暂停，空闲，出错
            //判断当前的文件大小
            File file = new File(mDownInfo.saveURL);
            //把当前的文件大小跟我们当前的进度进行一个对比
            //如果当前的文件为空，说明直接下载
            //如果当前的文件大小与我们进度一致，断点续传
            //如果文件不一致，说明出错，重新下载，删除以前文件，进度置空
            if (!file.exists()) {
                //文件不存在
                downApk();//重新下载
            } else {
                //文件存在
                if (file.length() == mDownInfo.progress) {
                    //断点续传
                    downApk();
                } else {
                    //出错，重新下载
                    file.delete();
                    mDownInfo.progress = 0;
                    mDownInfo.downState = NONE;
                    updateState(mDownInfo);
                    //重新下载
                    downApk();
                }
            }
        }
    }

    //下载apk
    private void downApk() {

    }

    //暂停
    public void pause() {

    }

    //安装
    public void installApk() {

    }

    //定义六种状态
    public static final int NONE = 100;//空闲
    public static final int DOWNING = 101;//下载
    public static final int PAUSE = 102;//暂停
    public static final int ERROR = 103;//错误
    public static final int SUCCESS = 104;//成功
    public static final int WAIT = 105;//等待

    //发布数据
    //1.定义接口
    public interface onDownListener {
        //进度
        void publishProgress();

        //状态
        void publishState(DownInfo downInfo);
    }

    //2.接收
//    private onDownListener mOnDownListener;
//
//    public void setOnDownListener(onDownListener onDownListener){
//        this.mOnDownListener = onDownListener;
//    }

    //定义当前监听的集合
    private List<onDownListener> mOnDownListeners = new ArrayList<>();

    public void addOnDownListener(onDownListener onDownListener) {
        if (!mOnDownListeners.contains(onDownListener)) {
            //不存在
            mOnDownListeners.add(onDownListener);
        }
    }
}
