package com.qun.googleplay.viewholder;

import android.view.View;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.DetailBean;
import com.qun.googleplay.global.GooglePlay;

/**
 * Created by Qun on 2017/7/16.
 */

public class BottomViewHolder extends BaseViewHolder<DetailBean> {

    @Override
    public View createItemView() {
        View view = View.inflate(GooglePlay.sContext, R.layout.bottomlayout, null);
        return view;
    }

    @Override
    public void bindView(DetailBean detailBean) {

    }
}
