package com.qun.googleplay.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.CategoryBean;
import com.qun.googleplay.global.GooglePlay;
import com.qun.googleplay.utils.Uris;

import butterknife.BindView;

/**
 * Created by Qun on 2017/7/11.
 */

public class BodyViewHolder extends BaseViewHolder<CategoryBean.InfosBean> {

    @BindView(R.id.iv_image1)
    ImageView mIvImage1;
    @BindView(R.id.tv_name1)
    TextView mTvName1;
    @BindView(R.id.ll_info_info01)
    LinearLayout mLlInfoInfo01;
    @BindView(R.id.iv_image2)
    ImageView mIvImage2;
    @BindView(R.id.tv_name2)
    TextView mTvName2;
    @BindView(R.id.ll_info2)
    LinearLayout mLlInfo2;
    @BindView(R.id.iv_image3)
    ImageView mIvImage3;
    @BindView(R.id.tv_name3)
    TextView mTvName3;
    @BindView(R.id.ll_info3)
    LinearLayout mLlInfo3;
    @BindView(R.id.ll_info_root_layout)
    LinearLayout mLlInfoRootLayout;

    @Override
    public View createItemView() {
        View view = View.inflate(GooglePlay.sContext, R.layout.adapter_info, null);
        return view;
    }

    @Override
    public void bindView(CategoryBean.InfosBean bodyBean) {

        mLlInfoInfo01.setVisibility(View.GONE);
        mLlInfo2.setVisibility(View.GONE);
        mLlInfo3.setVisibility(View.GONE);

        if(!TextUtils.isEmpty(bodyBean.getName1())){
            //有数据
            mLlInfoInfo01.setVisibility(View.VISIBLE);
            mTvName1.setText(bodyBean.getName1());
            setNetImage(Uris.IMAGE_HOST + bodyBean.getUrl1(), mIvImage1);
        }
        if(!TextUtils.isEmpty(bodyBean.getName2())){
            //有数据
            mLlInfo2.setVisibility(View.VISIBLE);
            mTvName2.setText(bodyBean.getName2());
            setNetImage(Uris.IMAGE_HOST + bodyBean.getUrl2(), mIvImage2);
        }
        if(!TextUtils.isEmpty(bodyBean.getName3())){
            //有数据
            mLlInfo3.setVisibility(View.VISIBLE);
            mTvName3.setText(bodyBean.getName3());
            setNetImage(Uris.IMAGE_HOST + bodyBean.getUrl3(), mIvImage3);
        }
    }
}
