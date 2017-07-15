package com.qun.googleplay.viewholder;

import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.DetailBean;
import com.qun.googleplay.global.GooglePlay;
import com.qun.googleplay.utils.Uris;

import butterknife.BindView;

/**
 * Created by Qun on 2017/7/15.
 */

public class TitleViewHolder extends BaseViewHolder<DetailBean> {

    @BindView(R.id.iv_head_icon)
    ImageView mIvHeadIcon;
    @BindView(R.id.tv_head_title)
    TextView mTvHeadTitle;
    @BindView(R.id.rb_head_score)
    RatingBar mRbHeadScore;
    @BindView(R.id.tv_head_down)
    TextView mTvHeadDown;
    @BindView(R.id.tv_head_date)
    TextView mTvHeadDate;
    @BindView(R.id.app_head_version)
    TextView mAppHeadVersion;
    @BindView(R.id.app_head_size)
    TextView mAppHeadSize;

    @Override
    public View createItemView() {
        View view = View.inflate(GooglePlay.sContext, R.layout.titlelayout, null);
        return view;
    }

    @Override
    public void bindView(DetailBean detailBean) {

        mTvHeadTitle.setText(detailBean.getName());
        mTvHeadDown.setText("下载:" + detailBean.getDownloadNum());
        mTvHeadDate.setText("日期:" + detailBean.getDate());
        mAppHeadVersion.setText("版本:" + detailBean.getVersion());
        String fileSize = Formatter.formatFileSize(GooglePlay.sContext, detailBean.getSize());
        mAppHeadSize.setText("大小:" + fileSize);

        mRbHeadScore.setRating(detailBean.getStars());

        //设置图片
        setNetImage(Uris.IMAGE_HOST + detailBean.getIconUrl(), mIvHeadIcon);
    }
}
