package com.qun.googleplay.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qun.googleplay.R;
import com.qun.googleplay.adapter.SubjectListAdapter;
import com.qun.googleplay.bean.SubjectBean;
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
 * Created by Qun on 2017/7/5.
 */

public class SubjectFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.pull_refresh_list)
    PullToRefreshListView mPullRefreshList;

    private List<SubjectBean> mShowItems = new ArrayList<>();
    private SubjectListAdapter mSubjectListAdapter;

    @Override
    protected View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_subject, null);
        unbinder = ButterKnife.bind(this, view);

        init();
        return view;
    }

    private void init() {
        mSubjectListAdapter = new SubjectListAdapter(mShowItems);
        ListView refreshableView = mPullRefreshList.getRefreshableView();
        refreshableView.setAdapter(mSubjectListAdapter);

        //设置模式
        mPullRefreshList.setMode(PullToRefreshBase.Mode.BOTH);

        //监听
        mPullRefreshList.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                //重新请求数据
//                mLoadPager.showPager();
                refreshData();
            }
        });
    }

    @Override
    public Object getData() {
        //判断当前的模式
        if (mPullRefreshList.getCurrentMode() == PullToRefreshBase.Mode.PULL_FROM_START) {
            //清空数据
            mShowItems.clear();
        }

        //请求数据
        List<SubjectBean> subjectBeanList = JsonCacheManager.getInstance().getDataList(Uris.SUBJECT_ADDRESS + mShowItems.size(), SubjectBean.class);

        /**
         * 1.当前的总集合等于0，当前的集合为0 失败
         * 2.当前的总集合等于0，当前的集合大于0，添加
         * 3.当前的总集合大于0，当前集合为0，没有数据
         * 4.当前的总集合大于0，当前集合大于0，添加
         */

        if (mShowItems.size() == 0) {
            if (subjectBeanList == null || subjectBeanList.size() == 0) {
                //1.当前的总集合等于0，当前的集合为0 失败
                return null;
            }else {
                //2.当前的总集合等于0，当前的集合大于0，添加
                mShowItems.addAll(subjectBeanList);
            }
        } else {
            if (subjectBeanList == null || subjectBeanList.size() == 0) {
                //3.当前的总集合大于0，当前集合为0，没有数据
                ToastUtil.showToast("当前已无数据");
            }else {
                //4.当前的总集合大于0，当前集合大于0，添加
                mShowItems.addAll(subjectBeanList);
            }
        }

        //更新ui
        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mSubjectListAdapter.notifyDataSetChanged();
                //刷新的状态置空
                mPullRefreshList.onRefreshComplete();
            }
        });
        return mShowItems;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
