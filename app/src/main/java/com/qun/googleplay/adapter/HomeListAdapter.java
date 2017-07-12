package com.qun.googleplay.adapter;

import com.qun.googleplay.bean.HomeBean;
import com.qun.googleplay.viewholder.BaseViewHolder;
import com.qun.googleplay.viewholder.HomeViewHolder;

import java.util.List;

/**
 * 把所有可变的都抽取到viewholder中
 * 把T类型放到最后去抽取
 * Created by Qun on 2017/7/4.
 */

public class HomeListAdapter extends MyBaseAdapter<HomeBean.HomeItem> {

    public HomeListAdapter(List<HomeBean.HomeItem> showItems) {
        super(showItems);
    }

    @Override
    public BaseViewHolder createViewHolder(int position) {
        return new HomeViewHolder();
    }
}
