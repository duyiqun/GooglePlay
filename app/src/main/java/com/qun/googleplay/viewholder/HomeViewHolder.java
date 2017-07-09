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

public class HomeViewHolder extends BaseViewHolder<HomeBean.HomeItem> {

    ImageView ivHomeIcon;
    TextView tvHomeTitle;
    RatingBar rbHomeStart;
    TextView tvHomeSize;
    TextView tvHomeDesc;

    @Override
    public View createItemView() {
        View view = View.inflate(GooglePlay.sContext, R.layout.item_home, null);

        ivHomeIcon = (ImageView) view.findViewById(R.id.iv_home_icon);
        tvHomeTitle = (TextView) view.findViewById(R.id.tv_home_title);
        rbHomeStart = (RatingBar) view.findViewById(R.id.rb_home_start);
        tvHomeSize = (TextView) view.findViewById(R.id.tv_home_size);
        tvHomeDesc = (TextView) view.findViewById(R.id.tv_home_desc);

        return view;
    }

    public void bindView(HomeBean.HomeItem homeItem) {
        tvHomeTitle.setText(homeItem.getName());
        rbHomeStart.setRating(homeItem.getStars());
        //格式大小
        String fileSize = Formatter.formatFileSize(GooglePlay.sContext, homeItem.getSize());
        tvHomeSize.setText(fileSize);
        tvHomeDesc.setText(homeItem.getDes());

        //图片设置
        setNetImage("http://127.0.0.1:8090/image?name=" + homeItem.getIconUrl(), ivHomeIcon);
    }
}
