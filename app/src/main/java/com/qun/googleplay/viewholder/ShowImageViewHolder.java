package com.qun.googleplay.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.DetailBean;
import com.qun.googleplay.global.GooglePlay;
import com.qun.googleplay.utils.Uris;
import com.qun.googleplay.utils.Utils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Qun on 2017/7/15.
 */

public class ShowImageViewHolder extends BaseViewHolder<DetailBean> {

    @BindView(R.id.ll_app_show_layout)
    LinearLayout mLlAppShowLayout;

    @Override
    public View createItemView() {
        View view = View.inflate(GooglePlay.sContext, R.layout.showimages, null);
        return view;
    }

    @Override
    public void bindView(DetailBean detailBean) {
        List<String> images = detailBean.getScreen();

        for (String image : images) {
            ImageView imageView = new ImageView(GooglePlay.sContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Utils.getDimens(R.dimen.dp90), Utils.getDimens(R.dimen.dp150));
            params.setMargins(Utils.getDimens(R.dimen.dp10), 0, 0, 0);
            imageView.setLayoutParams(params);

            setNetImage(Uris.IMAGE_HOST + image, imageView);
//            imageView.setImageResource(R.drawable.h12);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

//            <ImageView
//                android:layout_width="90dp"
//                android:layout_height="150dp"
//                android:layout_marginLeft="10dp"
//                android:background="@drawable/h12"/>
            //添加到linearlayout中
            mLlAppShowLayout.addView(imageView);
        }
    }
}
