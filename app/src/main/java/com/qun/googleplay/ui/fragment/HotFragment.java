package com.qun.googleplay.ui.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.ui.view.FlowLayout;
import com.qun.googleplay.utils.Utils;

/**
 * Created by Qun on 2017/7/13.
 */

public class HotFragment extends BaseFragment {

    @Override
    protected View createView() {
        FlowLayout flowLayout = new FlowLayout(getContext());

        //添加一个控件
        for (int i = 0; i < 30; i++) {
            TextView textView = new TextView(getContext());
            textView.setText("我要显示一行，给不给位置");

            //设置颜色
            textView.setBackgroundResource(R.drawable.hot_text_bg2);

            //居中
            textView.setGravity(Gravity.CENTER);

            //设置padding
            int dp10 = Utils.getDimens(R.dimen.dp10);
            textView.setPadding(dp10, dp10, dp10, dp10);

            flowLayout.addView(textView);
        }

        //设置边距
        int dp10 = Utils.getDimens(R.dimen.dp10);
        flowLayout.setPadding(dp10, dp10, dp10, dp10);

        return flowLayout;
    }

    @Override
    public Object getData() {
        return "";
    }
}
