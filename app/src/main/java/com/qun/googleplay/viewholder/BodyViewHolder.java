package com.qun.googleplay.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.HomeBodyBean;
import com.qun.googleplay.global.GooglePlay;

/**
 * Created by Qun on 2017/7/11.
 */

public class BodyViewHolder extends BaseViewHolder<HomeBodyBean> {

    private ImageView mIv;

    @Override
    public View createItemView() {
        mIv = new ImageView(GooglePlay.sContext);
        return mIv;
    }

    @Override
    public void bindView(HomeBodyBean homeBodyBean) {
        mIv.setImageResource(R.mipmap.ic_launcher);
    }
}
