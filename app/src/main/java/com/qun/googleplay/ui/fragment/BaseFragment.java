package com.qun.googleplay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qun.googleplay.ui.view.LoadPager;

/**
 * Created by Qun on 2017/5/2.
 */

public abstract class BaseFragment extends Fragment {

    private LoadPager mLoadPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //得到数据的方法
        if (mLoadPager == null) {
            mLoadPager = new LoadPager(getContext()) {

                //得到数据的方法
                @Override
                public Object getNetData() {
                    return getData();
                }

                @Override
                public View createSuccessView() {
                    return createView();
                }
            };
        }
        return mLoadPager;
    }

    //返回一个界面
    protected abstract View createView();

    //返回一个数据
    public abstract Object getData();
}
