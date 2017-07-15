package com.qun.googleplay.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.github.chrisbanes.photoview.PhotoView;
import com.qun.googleplay.utils.Fields;
import com.qun.googleplay.utils.Uris;
import com.qun.googleplay.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qun on 2017/7/15.
 */

public class ShowImagesFragment extends BaseFragment {

    private List<String> mImages = new ArrayList<>();

    @Override
    protected View createView() {

        //得到传递过来的数据
        Bundle bundle = getArguments();
        ArrayList<String> images = bundle.getStringArrayList(Fields.ShowImagesFragment.IMAGES);
        mImages.addAll(images);

        //得到当前点击的点
        int point = bundle.getInt(Fields.ShowImagesFragment.POINT);

        ViewPager viewPager = new ViewPager(getContext());
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mImages.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            //初始化
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                //可以缩放的图片显示控件
                PhotoView photoView = new PhotoView(getContext());
//                imageView.setImageResource(R.mipmap.ic_launcher);

                //设置图片
                Utils.setNetImage(Uris.IMAGE_HOST + mImages.get(position), photoView);

                //添加到viewgroup中
                container.addView(photoView);
                return photoView;
            }

            //销毁
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });

        //设置当前选中
        viewPager.setCurrentItem(point);

        return viewPager;
    }

    @Override
    public Object getData() {
        return "";
    }
}
