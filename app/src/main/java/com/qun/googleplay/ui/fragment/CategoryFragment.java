package com.qun.googleplay.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.qun.googleplay.R;
import com.qun.googleplay.adapter.CategoryAdapter;
import com.qun.googleplay.bean.HomeBodyBean;
import com.qun.googleplay.bean.HomeHeadBean;
import com.qun.googleplay.interfaces.ItemType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Qun on 2017/7/11.
 */

public class CategoryFragment extends BaseFragment {
    @BindView(R.id.lv_category_list)
    ListView mLvCategoryList;
    Unbinder unbinder;

    private List<ItemType> mShowItems = new ArrayList<>();
    private CategoryAdapter mCategoryAdapter;

    //布局
    @Override
    protected View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_category, null);
        unbinder = ButterKnife.bind(this, view);

        init();
        return view;
    }

    private void init() {
        mCategoryAdapter = new CategoryAdapter(mShowItems);
        mLvCategoryList.setAdapter(mCategoryAdapter);
    }

    //数据
    @Override
    public Object getData() {

        //模拟得到数据
        mShowItems.add(new HomeHeadBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeHeadBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        mShowItems.add(new HomeBodyBean());
        return "";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }
}
