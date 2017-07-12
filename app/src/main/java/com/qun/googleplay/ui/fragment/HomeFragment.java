package com.qun.googleplay.ui.fragment;

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
                refreshData();
            }
        });
    }

    //给个数据
    @Override
    public Object getData() {
        //刷新模式
        if (mPullRefreshList.getCurrentMode() == PullToRefreshBase.Mode.PULL_FROM_START) {//当前下拉刷新
            mShowItems.clear();
        }

        //获取数据
        HomeBean homeBean = JsonCacheManager.getInstance().getDataBean(Uris.HOME_ADDRESS + mShowItems.size(), HomeBean.class);

        //这样返回会有问题，前几页成功的，但是后面失败了
//        if (homeBean == null) {
//            return null;
//        }

        /**
         * 如果当前的总集合个数等于0，当前的数据为空，说明失败的
         *
         * 当前的总集合个数等于0，当前的数据不为空，说明成功的
         *
         * 当前的总集合个数不会为0，当前的数据为空，说明没有数据
         *
         * 当前总集合个数不会为0，当前的数据也不为空，说明成功的
         */

        if (mShowItems.size() > 0) {
            if (homeBean != null) {
                //当前总集合个数不会为0，当前的数据也不为空，说明成功的
                mShowItems.addAll(homeBean.getList());
            } else {
                //当前的总集合个数不会为0，当前的数据为空，说明没有数据
                ToastUtil.showToast("网络未知错误");
            }
        } else {
            if (homeBean != null) {
                //当前的总集合个数等于0，当前的数据不为空，说明成功的
                mShowItems.addAll(homeBean.getList());
            } else {
                //如果当前的总集合个数等于0，当前的数据为空，说明失败的
                return null;
            }
        }

        System.out.println("当前的集合数：" + mShowItems.size());

        //更新数据
        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mHomeListAdapter.notifyDataSetChanged();
                mPullRefreshList.onRefreshComplete();
            }
        });

        return mShowItems;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }
}
