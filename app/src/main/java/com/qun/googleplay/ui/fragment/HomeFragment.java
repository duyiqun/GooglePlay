package com.qun.googleplay.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.qun.googleplay.bean.HomeBean;
import com.qun.googleplay.cachemanager.JsonCacheManager;
import com.qun.googleplay.utils.Utils;

/**
 * Created by Qun on 2017/5/2.
 */

public class HomeFragment extends BaseFragment {

    private TextView mTextView;

    //创建一个界面
    @Override
    protected View createView() {
        mTextView = new TextView(getContext());
        mTextView.setText("我是框架生的");
        return mTextView;
    }

    //给个数据
    @Override
    public Object getData() {
        //获取数据
        final HomeBean homeBean = (HomeBean) JsonCacheManager.getInstance().getDataBean("http://127.0.0.1:8090/home?index=0", HomeBean.class);

        //更新数据
        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mTextView.setText(homeBean.getList().get(0).getName());
            }
        });

        return "";
    }
}
