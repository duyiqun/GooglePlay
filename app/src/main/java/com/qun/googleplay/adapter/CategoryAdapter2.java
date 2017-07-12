package com.qun.googleplay.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qun.googleplay.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个categoryAdapter
 * Created by Qun on 2017/7/11.
 */

public class CategoryAdapter2 extends BaseAdapter {

    private List<Object> mShowItems = new ArrayList<>();

    public CategoryAdapter2(List<Object> showItems) {
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

    public static final int HEAD_TYPE = 0;
    public static final int BODY_TYPE = 1;

    //多条目
    @Override
    public int getItemViewType(int position) {
        if (mShowItems.get(position) instanceof String) {
            return HEAD_TYPE;
        } else {
            return BODY_TYPE;
        }
    }

    //几个条目
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //根据分类显示不同的view
        switch (getItemViewType(position)) {
            case HEAD_TYPE:
                TextView textView = new TextView(parent.getContext());
                textView.setText("我是头");
                return textView;
            case BODY_TYPE:
                ImageView imageView = new ImageView(parent.getContext());
                imageView.setImageResource(R.mipmap.ic_launcher);
                return imageView;
            default:
                break;
        }
        return null;
    }
}
