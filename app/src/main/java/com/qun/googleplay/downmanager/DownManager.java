package com.qun.googleplay.downmanager;

import java.util.ArrayList;
import java.util.List;

/**
 * 下载的框架
 * Created by Qun on 2017/7/17.
 */

public class DownManager {

    private DownManager(){

    }

    private static DownManager sDownManager = new DownManager();

    public static DownManager getInstance(){
        return sDownManager;
    }

    //定义方法
    //下载方法
    public void down(){

    }

    //暂停
    public void pause(){

    }

    //安装
    public void installApk(){

    }

    //定义六种状态
    public static final int NONE = 100;//空闲
    public static final int LOADING = 101;//下载
    public static final int PAUSE = 102;//暂停
    public static final int ERROR = 103;//错误
    public static final int SUCCESS = 104;//成功
    public static final int WAIT = 105;//等待

    //发布数据
    //1.定义接口
    public interface onDownListener{
        //进度
        void publishProgress();
        //状态
        void publishState();
    }

    //2.接收
//    private onDownListener mOnDownListener;
//
//    public void setOnDownListener(onDownListener onDownListener){
//        this.mOnDownListener = onDownListener;
//    }

    //定义当前监听的集合
    private List<onDownListener> mOnDownListeners = new ArrayList<>();

    public void addOnDownListener(onDownListener onDownListener){
        if(!mOnDownListeners.contains(onDownListener)){
            //不存在
            mOnDownListeners.add(onDownListener);
        }
    }
}
