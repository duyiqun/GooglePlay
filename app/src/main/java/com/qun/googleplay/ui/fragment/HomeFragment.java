package com.qun.googleplay.ui.fragment;

import android.os.SystemClock;
import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.qun.googleplay.R;
import com.qun.googleplay.adapter.HomeListAdapter;
import com.qun.googleplay.bean.HomeBean;
import com.qun.googleplay.cachemanager.JsonCacheManager;
import com.qun.googleplay.utils.ToastUtil;
import com.qun.googleplay.utils.Uris;
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

    Unbinder unbinder;
    @BindView(R.id.pull_refresh_list)
    com.handmark.pulltorefresh.library.PullToRefreshListView mPullRefreshList;
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
        //设置模式
        mPullRefreshList.setMode(PullToRefreshBase.Mode.BOTH);//可以上拉也可以下拉

        mHomeListAdapter = new HomeListAdapter(mShowItems);

        //获取listView
        ListView refreshableView = mPullRefreshList.getRefreshableView();
        refreshableView.setAdapter(mHomeListAdapter);

        //设置刷新监听
        mPullRefreshList.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                ToastUtil.showToast("下拉刷新了");

                //重新加载一次数据
                mLoadPager.showPager();
            }
        });
    }

    //给个数据
    @Override
    public Object getData() {
        //获取数据
        HomeBean homeBean = JsonCacheManager.getInstance().getDataBean(Uris.HOME_ADDRESS, HomeBean.class);

        SystemClock.sleep(2000);

        mShowItems.addAll(homeBean.getList());

        //更新数据
        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mHomeListAdapter.notifyDataSetChanged();
                mPullRefreshList.onRefreshComplete();
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
