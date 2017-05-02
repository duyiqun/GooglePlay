package com.qun.googleplay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qun.googleplay.R;
import com.qun.googleplay.ui.view.LoadPager;

import java.util.ArrayList;

/**
 * Created by Qun on 2017/5/2.
 */

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LoadPager loadPager = new LoadPager(getContext()) {

            //得到数据的方法
            @Override
            public Object getNetData() {
                ArrayList<Object> objects = new ArrayList<>();
                objects.add(new Object());
                return objects;
            }

            @Override
            public View createSuccessView() {
                ImageView imageView = new ImageView(getContext());
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(30, 30);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageResource(R.mipmap.ic_launcher);
                return imageView;
            }
        };
        return loadPager;
    }
}
