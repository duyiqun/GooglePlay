package com.qun.googleplay.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.qun.googleplay.R;
import com.qun.googleplay.adapter.HomeListAdapter;
import com.qun.googleplay.bean.HomeBean;
import com.qun.googleplay.cachemanager.JsonCacheManager;
import com.qun.googleplay.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Qun on 2017/5/2.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.lv_home_list_layout)
    ListView mLvHomeListLayout;
    Unbinder unbinder;
    private List<HomeBean.HomeItem> mShowItems = new ArrayList<>();
    private HomeListAdapter mHomeListAdapter;

    //创建一个界面
    @Override
    protected View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    //初始化代码
    private void init() {
        mHomeListAdapter = new HomeListAdapter(mShowItems);
        mLvHomeListLayout.setAdapter(mHomeListAdapter);
    }

    //给个数据
    @Override
    public Object getData() {
        //获取数据
        final HomeBean homeBean = (HomeBean) JsonCacheManager.getInstance().getDataBean("http://127.0.0.1:8090/home?index=0", HomeBean.class);

        mShowItems.addAll(homeBean.getList());

        //更新数据
        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mHomeListAdapter.notifyDataSetChanged();
            }
        });

        return "";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
