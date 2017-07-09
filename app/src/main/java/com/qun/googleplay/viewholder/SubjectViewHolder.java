package com.qun.googleplay.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.SubjectBean;
import com.qun.googleplay.global.GooglePlay;

/**
 * Created by Qun on 2017/7/6.
 */

public class SubjectViewHolder extends BaseViewHolder<SubjectBean> {

    ImageView ivImage;
    TextView tvDes;

    @Override
    public View createItemView() {
        View view = View.inflate(GooglePlay.sContext, R.layout.adapter_subject, null);

        ivImage = (ImageView) view.findViewById(R.id.iv_image);
        tvDes = (TextView) view.findViewById(R.id.tv_des);

        return view;
    }

    public void bindView(SubjectBean subjectBean) {
        tvDes.setText(subjectBean.getDes());
    }
}
