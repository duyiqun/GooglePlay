package com.qun.googleplay.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.cachemanager.JsonCacheManager;
import com.qun.googleplay.ui.view.FlowLayout;
import com.qun.googleplay.utils.ToastUtil;
import com.qun.googleplay.utils.Uris;
import com.qun.googleplay.utils.Utils;

import java.util.List;

/**
 * Created by Qun on 2017/7/13.
 */

public class HotFragment extends BaseFragment {

    private int mDp10;
    private FlowLayout mFlowLayout;

    @Override
    protected View createView() {

        mDp10 = Utils.getDimens(R.dimen.dp10);

        //让控件可以滚动
        ScrollView scrollView = new ScrollView(getContext());

        //流式布局
        mFlowLayout = new FlowLayout(getContext());

        //设置边距
        mFlowLayout.setPadding(mDp10, mDp10, mDp10, mDp10);

        //添加到滚动布局中
        scrollView.addView(mFlowLayout);

        return scrollView;
    }

    @Override
    public Object getData() {

        //请求数据
        final List<String> hots = JsonCacheManager.getInstance().getDataList(Uris.HOT_ADDRESS, String.class);

        if (hots == null || hots.size() == 0) {
            return null;
        }

        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                //添加一个控件
                for (int i = 0; i < hots.size(); i++) {
                    final TextView textView = new TextView(getContext());
                    textView.setText(hots.get(i));

                    //设置颜色
                    textView.setBackgroundResource(R.drawable.hot_text_bg2);
                    //使用代码去设置

                    //g
                    //创建图片
                    //创建一个颜色选择器
                    StateListDrawable stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, getGradientDrawable());//按下图片
                    stateListDrawable.addState(new int[]{}, getGradientDrawable());//按下图片

                    //设置进入出去的效果
                    stateListDrawable.setEnterFadeDuration(1000);
                    stateListDrawable.setExitFadeDuration(1000);

//                    GradientDrawable gradientDrawable = getGradientDrawable();
                    textView.setBackgroundDrawable(stateListDrawable);//背景

                    //设置字体的颜色
                    textView.setTextColor(Color.WHITE);

                    //居中
                    textView.setGravity(Gravity.CENTER);

                    //设置padding
                    textView.setPadding(mDp10, mDp10, mDp10, mDp10);

                    //设置点击
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.showToast("我被点了" + textView.getText().toString());
                        }
                    });

                    mFlowLayout.addView(textView);
                }
            }
        });
        return hots;
    }

    //随机生成一张图片
    @NonNull
    private GradientDrawable getGradientDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();//相当于shape文件
        gradientDrawable.setColor(GradientDrawable.RECTANGLE);//矩形
        gradientDrawable.setCornerRadius(mDp10);//设置圆角
        gradientDrawable.setColor(Utils.randomColor());//设置颜色
        return gradientDrawable;
    }
}
