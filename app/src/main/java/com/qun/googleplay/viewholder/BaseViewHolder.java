package com.qun.googleplay.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.qun.googleplay.R;

import butterknife.ButterKnife;

/**
 * Created by Qun on 2017/7/6.
 */

public abstract class BaseViewHolder<T> {

    View mView;
    public DisplayImageOptions mOptions;
    public DisplayImageOptions mRoundedOptions;

    public BaseViewHolder() {
        mView = createItemView();

        //登记证
        mView.setTag(this);

        ButterKnife.bind(this, mView);

        mOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) //显示图片加载中
                .showImageForEmptyUri(R.mipmap.ic_launcher) //空的图片
                .showImageOnFail(R.mipmap.ic_launcher) //错误的图片
                .cacheInMemory(true) //内存缓存要不要
                .cacheOnDisk(true) //sd卡缓存要不要
                .considerExifParams(true)//会识别图片的方向信息
                .displayer(new FadeInBitmapDisplayer(500)).build();//显示的效果
//        		.displayer(new RoundedBitmapDisplayer(36)).build();//圆形图片

        mRoundedOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) //显示图片加载中
                .showImageForEmptyUri(R.mipmap.ic_launcher) //空的图片
                .showImageOnFail(R.mipmap.ic_launcher) //错误的图片
                .cacheInMemory(true) //内存缓存要不要
                .cacheOnDisk(true) //sd卡缓存要不要
                .considerExifParams(true)//会识别图片的方向信息
                .displayer(new FadeInBitmapDisplayer(500)).build();//显示的效果
//        		.displayer(new RoundedBitmapDisplayer(36)).build();//圆形图片
    }

    //子类传入布局
    public abstract View createItemView();

    public abstract void bindView(T t);

    //返回一个view
    public View getView() {
        return mView;
    }

    //设置图片的方法
    public void setNetImage(String url, ImageView view) {
        /**
         * 1.图片的地址
         * 2.图片的控件
         * 3.图片的设置
         */
        ImageLoader.getInstance().displayImage(url, view, mOptions);
    }

    //设置圆形图片的方法
    public void setNetRoundedImage(String url, ImageView view) {
        /**
         * 1.图片的地址
         * 2.图片的控件
         * 3.图片的设置
         */
        ImageLoader.getInstance().displayImage(url, view, mRoundedOptions);
    }
}
