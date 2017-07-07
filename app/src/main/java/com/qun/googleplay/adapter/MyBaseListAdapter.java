package com.qun.googleplay.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qun.googleplay.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 把所有可变的都抽取到viewholder中
 * 把T类型放到最后去抽取
 * Created by Qun on 2017/7/4.
 */

public abstract class MyBaseListAdapter<T> extends BaseAdapter {

    private List<T> mShowItems = new ArrayList();

    public MyBaseListAdapter(List<T> showItems) {
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
            viewHolder = createViewHolder();
        } else {
            viewHolder = (BaseViewHolder) convertView.getTag();
        }
        //数据绑定(更新)
        viewHolder.bindView(mShowItems.get(position));
        return viewHolder.getView();
    }

    //子类传入viewHolder
    public abstract BaseViewHolder createViewHolder();
}
