package com.qun.googleplay.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.qun.googleplay.R;
import com.qun.googleplay.adapter.CategoryAdapter;
import com.qun.googleplay.bean.CategoryBean;
import com.qun.googleplay.bean.CategoryHeadBean;
import com.qun.googleplay.cachemanager.JsonCacheManager;
import com.qun.googleplay.interfaces.ItemType;
import com.qun.googleplay.utils.Uris;
import com.qun.googleplay.utils.Utils;

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

        List<CategoryBean> categoryBeanList = JsonCacheManager.getInstance().getDataList(Uris.CATEFORY_URL, CategoryBean.class);

        //异常处理
        if (categoryBeanList == null || categoryBeanList.size() == 0) {
            return null;
        }

        for (int i = 0; i < categoryBeanList.size(); i++) {
            CategoryBean categoryBean = categoryBeanList.get(i);
            //加入到集合中
            String title = categoryBean.getTitle();

            mShowItems.add(new CategoryHeadBean(title));
            mShowItems.addAll(categoryBean.getInfos());
        }

        //更新数据
        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mCategoryAdapter.notifyDataSetChanged();
            }
        });
        return categoryBeanList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }
}
