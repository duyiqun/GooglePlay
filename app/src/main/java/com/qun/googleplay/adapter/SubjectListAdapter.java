package com.qun.googleplay.adapter;

import com.qun.googleplay.bean.SubjectBean;
import com.qun.googleplay.viewholder.BaseViewHolder;
import com.qun.googleplay.viewholder.SubjectViewHolder;

import java.util.List;

/**
 * Created by Qun on 2017/7/5.
 */

public class SubjectListAdapter extends MyBaseListAdapter<SubjectBean> {

    public SubjectListAdapter(List<SubjectBean> showItems) {
        super(showItems);
    }

    @Override
    public BaseViewHolder createViewHolder() {
        return new SubjectViewHolder();
    }
}
