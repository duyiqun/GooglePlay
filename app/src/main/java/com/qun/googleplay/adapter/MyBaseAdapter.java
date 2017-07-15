package com.qun.googleplay.adapter;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;

import com.qun.googleplay.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 把所有可变的都抽取到viewholder中
 * 把T类型放到最后去抽取
 * Created by Qun on 2017/7/4.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {

    private List<T> mShowItems = new ArrayList();

    public MyBaseAdapter(List<T> showItems) {
        mShowItems = showItems;
    }

    @Override
    public int getCount() {
        return mShowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mShowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder<T> viewHolder;
        if (convertView == null) {
            viewHolder = createViewHolder(position);
        } else {
            viewHolder = (BaseViewHolder) convertView.getTag();
        }
        //数据绑定(更新)
        viewHolder.bindView(mShowItems.get(position));

        View view = viewHolder.getView();
        //缩放
        view.setScaleX(.6f);
        view.setScaleY(.6f);

        //旋转
        if (position % 2 == 0) {
            view.setRotation(90f);
        } else {
            view.setRotation(-90f);
        }

        //全新的动画
        ViewCompat.animate(view).scaleX(1.0f).scaleY(1.0f).rotation(0).setDuration(500).setInterpolator(new OvershootInterpolator()).start();
        return view;
    }

    //子类传入viewHolder
    public abstract BaseViewHolder createViewHolder(int position);
}
