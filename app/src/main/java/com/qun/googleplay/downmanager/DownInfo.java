package com.qun.googleplay.downmanager;

import android.os.Environment;

import com.qun.googleplay.bean.DetailBean;
import com.qun.googleplay.global.GooglePlay;

import java.io.File;

/**
 * 下载信息
 * Created by Qun on 2017/7/17.
 */

public class DownInfo {

    //状态
    public int downState;
    //下载地址
    public String downURL;
    //保存地址
    public String saveURL;
    //进度
    public long progress;
    //大小
    public long fileSize;
    //id
    public int id;

    public DownInfo(DetailBean detailBean) {
        downState = DownManager.NONE;//第一次
        downURL = detailBean.getDownloadUrl();//下载地址
        //sd卡/包名/downs/应用名.apk
        saveURL = Environment.getExternalStorageDirectory().getPath() + File.separator + GooglePlay.sContext.getPackageName() + File.separator + "downs" + detailBean.getName() + ".apk";
        progress = 0;//当前进度为0
        fileSize = detailBean.getSize();//大小
        id = detailBean.getId();//唯一标志
    }
}
