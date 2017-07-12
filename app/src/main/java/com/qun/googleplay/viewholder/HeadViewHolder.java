package com.qun.googleplay.viewholder;

import android.view.View;
import android.widget.TextView;

import com.qun.googleplay.bean.HomeBean;
import com.qun.googleplay.bean.HomeHeadBean;
import com.qun.googleplay.global.GooglePlay;

/**
 * Created by Qun on 2017/7/11.
 */

public class HeadViewHolder extends BaseViewHolder<HomeHeadBean> {

    private TextView mTextView;

    @Override
    public View createItemView() {
        mTextView = new TextView(GooglePlay.sContext);
        return mTextView;
    }

    @Override
    public void bindView(HomeHeadBean homeHeadBean) {
        mTextView.setText("我是新头");
    }
}
