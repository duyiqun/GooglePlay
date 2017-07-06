package com.qun.googleplay.viewholder;

import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.HomeBean;
import com.qun.googleplay.global.GooglePlay;

/**
 * Created by Qun on 2017/7/6.
 */

public class HomeViewHolder {

    ImageView ivHomeIcon;
    TextView tvHomeTitle;
    RatingBar rbHomeStart;
    TextView tvHomeSize;
    TextView tvHomeDesc;
    View mView;

    public HomeViewHolder() {
//        public ViewHolder(View view) {
        View mView = View.inflate(GooglePlay.sContext, R.layout.item_home, null);

        //登记证
        mView.setTag(this);

        ivHomeIcon = (ImageView) mView.findViewById(R.id.iv_home_icon);
        tvHomeTitle = (TextView) mView.findViewById(R.id.tv_home_title);
        rbHomeStart = (RatingBar) mView.findViewById(R.id.rb_home_start);
        tvHomeSize = (TextView) mView.findViewById(R.id.tv_home_size);
        tvHomeDesc = (TextView) mView.findViewById(R.id.tv_home_desc);
    }

    public void bindView(HomeBean.HomeItem homeItem) {
        tvHomeTitle.setText(homeItem.getName());
        rbHomeStart.setRating(homeItem.getStars());
        //格式大小
        String fileSize = Formatter.formatFileSize(GooglePlay.sContext, homeItem.getSize());
        tvHomeSize.setText(fileSize);
        tvHomeDesc.setText(homeItem.getDes());
    }

    //返回一个view
    public View getView() {
        return mView;
    }
}
