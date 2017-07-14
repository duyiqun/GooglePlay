package com.qun.googleplay.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.qun.googleplay.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Qun on 2017/7/13.
 */

public class DetailFragment extends BaseFragment {

    @BindView(R.id.tv_detail_show)
    TextView mTvDetailShow;
    Unbinder unbinder;

    @Override
    protected View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_detail, null);
        unbinder = ButterKnife.bind(this, view);
        //获取对象
        Bundle bundle = getArguments();
        mTvDetailShow.setText("当前的数据：" + bundle.getInt("int"));
        return view;
    }

    @Override
    public Object getData() {
        return "";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
