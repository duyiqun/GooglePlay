package com.qun.googleplay.viewholder;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.DetailBean;
import com.qun.googleplay.global.GooglePlay;

import butterknife.BindView;

/**
 * Created by Qun on 2017/7/15.
 */

public class DescViewHolder extends BaseViewHolder<DetailBean> {

    @BindView(R.id.tv_app_desc)
    TextView mTvAppDesc;
    @BindView(R.id.tv_app_desc_title)
    TextView mTvAppDescTitle;
    @BindView(R.id.iv_desc_arrow)
    ImageView mIvDescArrow;
    @BindView(R.id.ll_desc_root_layout)
    LinearLayout mLlDescRootLayout;
    private int mHeight_max;
    private int mHeight_5;

    private boolean isOpen = false;

    //接收一个scrollView
    private ScrollView mScrollView;

    @Override
    public View createItemView() {
        View view = View.inflate(GooglePlay.sContext, R.layout.desclayout, null);
        return view;
    }

    @Override
    public void bindView(DetailBean detailBean) {
        mTvAppDesc.setText(detailBean.getDes());
        mTvAppDescTitle.setText(detailBean.getName());

        //设置当前显示5行
        mTvAppDesc.setMaxLines(5);

        //设置5行
        mTvAppDesc.setLines(5);
        mTvAppDesc.measure(0, 0);
        mHeight_5 = mTvAppDesc.getMeasuredHeight();

        mTvAppDesc.setMaxLines(1024);

//        mTvAppDesc.measure(0, 0);
//        int height_max = mTvAppDesc.getMeasuredHeight();

        //布局完成时
        mTvAppDesc.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //马上删除
                mTvAppDesc.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                //得到当前5行的高度
                mHeight_max = mTvAppDesc.getHeight();

                //设置当前最大的高度为5行
                mTvAppDesc.setHeight(mHeight_5);
            }
        });

        //设置监听
        mLlDescRootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = new ValueAnimator();
                if (isOpen) {
                    //如果当前是打开的，那么点击以后关闭
                    //最高的高度到五行的高度
                    valueAnimator.setIntValues(mHeight_max, mHeight_5);
                } else {
                    //如果当前是关闭的，那么点击以后打开
                    //五行的高度到最高的高度
                    valueAnimator.setIntValues(mHeight_5, mHeight_max);
                }

                isOpen = !isOpen;

                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int animatedValue = (int) animation.getAnimatedValue();
                        mTvAppDesc.setHeight(animatedValue);

                        //在做动画的那一刻直接滚动到底
                        mScrollView.smoothScrollTo(0, 1024);
                    }
                });
                valueAnimator.setDuration(1000);
                valueAnimator.start();
            }
        });
    }

    //接收
    public void setScrollView(ScrollView scrollView) {
        this.mScrollView = scrollView;
    }
}
