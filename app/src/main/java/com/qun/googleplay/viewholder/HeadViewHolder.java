package com.qun.googleplay.viewholder;

import android.view.View;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.CategoryHeadBean;
import com.qun.googleplay.global.GooglePlay;

import butterknife.BindView;

/**
 * Created by Qun on 2017/7/11.
 */

public class HeadViewHolder extends BaseViewHolder<CategoryHeadBean> {

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @Override
    public View createItemView() {
        View view = View.inflate(GooglePlay.sContext, R.layout.adapter_title, null);
        return view;
    }

    @Override
    public void bindView(CategoryHeadBean headBean) {

        mTvTitle.setText(headBean.title);
    }
}
