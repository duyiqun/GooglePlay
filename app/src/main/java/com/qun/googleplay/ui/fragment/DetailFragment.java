package com.qun.googleplay.ui.fragment;

import android.view.View;

import com.qun.googleplay.R;

/**
 * Created by Qun on 2017/7/13.
 */

public class DetailFragment extends BaseFragment {

    @Override
    protected View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_detail,null);
        return view;
    }

    @Override
    public Object getData() {
        return "";
    }
}
