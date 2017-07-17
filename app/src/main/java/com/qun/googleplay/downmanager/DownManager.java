package com.qun.googleplay.downmanager;

import android.util.SparseArray;

import com.qun.googleplay.bean.DetailBean;
import com.qun.googleplay.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 下载的框架
 * Created by Qun on 2017/7/17.
 */

public class DownManager {

    private DownManager() {

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
    public class DownRunnable implements Runnable{

        private DownInfo mDownInfo;

        //得到downinfo信息
        public DownRunnable(DownInfo downInfo) {
            this.mDownInfo = downInfo;
        }

        //一运行把状态改成下载
        @Override
        public void run() {
            mDownInfo.downState = DOWN;//下载状态
            updateState(mDownInfo);//发布状态


        }
    }

    //暂停
    public void pause() {

    }

    //安装
    public void installApk() {

    }

    //定义六种状态
    public static final int NONE = 100;//空闲
    public static final int DOWN = 101;//下载
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
