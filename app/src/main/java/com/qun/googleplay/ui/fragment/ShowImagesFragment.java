package com.qun.googleplay.ui.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Qun on 2017/7/15.
 */

public class ShowImagesFragment extends BaseFragment {

    @Override
    protected View createView() {
        TextView textView = new TextView(getContext());
        textView.setText("当前的展示图片界面");
        return textView;
    }

    @Override
    public Object getData() {
        return "";
    }
}
