package com.qun.googleplay.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.DetailBean;
import com.qun.googleplay.global.GooglePlay;
import com.qun.googleplay.utils.Uris;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Qun on 2017/7/15.
 */

public class SafeViewHolder extends BaseViewHolder<DetailBean> {

    @BindView(R.id.iv_safe_title_01)
    ImageView mIvSafeTitle01;
    @BindView(R.id.iv_safe_title02)
    ImageView mIvSafeTitle02;
    @BindView(R.id.iv_safe_title03)
    ImageView mIvSafeTitle03;
    @BindView(R.id.iv_safe_arrow)
    ImageView mIvSafeArrow;
    @BindView(R.id.iv_safe_content01)
    ImageView mIvSafeContent01;
    @BindView(R.id.tv_safe_content01)
    TextView mTvSafeContent01;
    @BindView(R.id.ll_safe_01)
    LinearLayout mLlSafe01;
    @BindView(R.id.iv_safe_content02)
    ImageView mIvSafeContent02;
    @BindView(R.id.tv_safe_content02)
    TextView mTvSafeContent02;
    @BindView(R.id.ll_safe_02)
    LinearLayout mLlSafe02;
    @BindView(R.id.iv_safe_content03)
    ImageView mIvSafeContent03;
    @BindView(R.id.tv_safe_content03)
    TextView mTvSafeContent03;
    @BindView(R.id.ll_safe_03)
    LinearLayout mLlSafe03;
    @BindView(R.id.ll_app_safe_content_layout)
    LinearLayout mLlAppSafeContentLayout;
    @BindView(R.id.ll_safe_root_layout)
    LinearLayout mLlSafeRootLayout;

    @Override
    public View createItemView() {
        View view = View.inflate(GooglePlay.sContext, R.layout.safelayout, null);
        return view;
    }

    @Override
    public void bindView(DetailBean detailBean) {

        //先全部隐藏
        mLlSafe01.setVisibility(View.GONE);
        mLlSafe02.setVisibility(View.GONE);
        mLlSafe03.setVisibility(View.GONE);

        mLlSafeRootLayout.setVisibility(View.GONE);

        List<DetailBean.SafeBean> safes = detailBean.getSafe();
        if (safes == null || safes.size() == 0) {
            //什么都不做
        } else {
            //开始显示数据
            mLlSafeRootLayout.setVisibility(View.VISIBLE);
            switch (safes.size()) {
                case 3:
                    mTvSafeContent03.setText(safes.get(2).getSafeDes());
                    setNetImage(Uris.IMAGE_HOST + safes.get(2).getSafeUrl(), mIvSafeTitle03);
                    setNetImage(Uris.IMAGE_HOST + safes.get(2).getSafeDesUrl(), mIvSafeContent03);
                    mLlSafe03.setVisibility(View.VISIBLE);
                case 2:
                    mTvSafeContent02.setText(safes.get(1).getSafeDes());
                    setNetImage(Uris.IMAGE_HOST + safes.get(1).getSafeUrl(), mIvSafeTitle02);
                    setNetImage(Uris.IMAGE_HOST + safes.get(1).getSafeDesUrl(), mIvSafeContent02);
                    mLlSafe02.setVisibility(View.VISIBLE);
                case 1:
                    mTvSafeContent01.setText(safes.get(0).getSafeDes());
                    setNetImage(Uris.IMAGE_HOST + safes.get(0).getSafeUrl(), mIvSafeTitle01);
                    setNetImage(Uris.IMAGE_HOST + safes.get(0).getSafeDesUrl(), mIvSafeContent01);
                    mLlSafe01.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        }


    }
}
