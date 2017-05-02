package com.qun.googleplay.ui.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Qun on 2017/5/2.
 */

public class HomeFragment extends BaseFragment {

    //创建一个界面
    @Override
    protected View createView() {
        TextView textView = new TextView(getContext());
        textView.setText("我是框架生的");
        return textView;
    }

    //给个数据
    @Override
    public Object getData() {
        return "";
    }
}
