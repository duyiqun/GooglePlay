package com.qun.googleplay.viewholder;

import android.view.View;

/**
 * Created by Qun on 2017/7/6.
 */

public abstract class BaseViewHolder<T> {

    View mView;

    public BaseViewHolder() {
        mView = createItemView();

        //登记证
        mView.setTag(this);
    }

    //子类传入布局
    public abstract View createItemView();

    public abstract void bindView(T t);

    //返回一个view
    public View getView() {
        return mView;
    }
}
