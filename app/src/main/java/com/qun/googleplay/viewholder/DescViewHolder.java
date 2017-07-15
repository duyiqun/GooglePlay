package com.qun.googleplay.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        mTvAppDesc.measure(0, 0);
        int height_5 = mTvAppDesc.getMeasuredHeight();

        mTvAppDesc.setMaxLines(1024);

        mTvAppDesc.measure(0, 0);
        int height_max = mTvAppDesc.getMeasuredHeight();
    }
}
