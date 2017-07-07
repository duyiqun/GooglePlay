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

public class SubjectViewHolder2 {

    ImageView ivImage;
    TextView tvDes;
    View mView;

    public SubjectViewHolder2() {
        mView = View.inflate(GooglePlay.sContext, R.layout.adapter_subject, null);

        mView.setTag(this);

        ivImage = (ImageView) mView.findViewById(R.id.iv_image);
        tvDes = (TextView) mView.findViewById(R.id.tv_des);
    }

    public void bindView(SubjectBean subjectBean) {
        tvDes.setText(subjectBean.getDes());
    }

    //返回一个view
    public View getView() {
        return mView;
    }
}
