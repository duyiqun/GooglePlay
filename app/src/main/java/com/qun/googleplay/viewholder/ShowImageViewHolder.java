package com.qun.googleplay.viewholder;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.DetailBean;
import com.qun.googleplay.global.GooglePlay;
import com.qun.googleplay.ui.fragment.ShowImagesFragment;
import com.qun.googleplay.utils.Fields;
import com.qun.googleplay.utils.Uris;
import com.qun.googleplay.utils.Utils;

import java.util.ArrayList;

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
        final ArrayList<String> images = (ArrayList<String>) detailBean.getScreen();

        for (int i = 0; i < images.size(); i++) {
            ImageView imageView = new ImageView(GooglePlay.sContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Utils.getDimens(R.dimen.dp90), Utils.getDimens(R.dimen.dp150));
            params.setMargins(Utils.getDimens(R.dimen.dp10), 0, 0, 0);
            imageView.setLayoutParams(params);

            setNetImage(Uris.IMAGE_HOST + images.get(i), imageView);
//            imageView.setImageResource(R.drawable.h12);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            //设置点击事件
            final int finalI = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(Fields.ShowImagesFragment.IMAGES, images);
                    bundle.putInt(Fields.ShowImagesFragment.POINT, finalI);
                    Utils.startFragment(ShowImagesFragment.class, bundle);
                }
            });

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
