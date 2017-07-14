package com.qun.googleplay.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qun.googleplay.ui.activity.ShowActivity;
import com.qun.googleplay.ui.view.LoadPager;
import com.qun.googleplay.utils.Fields;

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

    //刷新数据
    public void refreshData() {
        mLoadPager.showPager();
    }

    //启动fragment
    public void startFragment(Class clss, Bundle bundle) {
        Intent intent = new Intent(getContext(), ShowActivity.class);
        intent.putExtra(Fields.ShowActivity.CLASSNAME, clss);
        intent.putExtra(Fields.ShowActivity.BUNDLE, bundle);
        startActivity(intent);
    }
}
