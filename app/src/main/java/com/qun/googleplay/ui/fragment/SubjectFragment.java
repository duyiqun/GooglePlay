package com.qun.googleplay.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.qun.googleplay.R;
import com.qun.googleplay.adapter.SubjectListAdapter;
import com.qun.googleplay.bean.SubjectBean;
import com.qun.googleplay.cachemanager.JsonCacheManager;
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

    @BindView(R.id.lv_subject_list_layout)
    ListView mLvSubjectListLayout;
    Unbinder unbinder;

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
        mLvSubjectListLayout.setAdapter(mSubjectListAdapter);
    }

    @Override
    public Object getData() {
        //请求数据
        List<SubjectBean> subjectBeanList = JsonCacheManager.getInstance().getDataList("http://127.0.0.1:8090/subject?index=0", SubjectBean.class);
        mShowItems.addAll(subjectBeanList);

        //更新ui
        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mSubjectListAdapter.notifyDataSetChanged();
            }
        });
        return subjectBeanList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
