package com.qun.googleplay.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.qun.googleplay.bean.FragmentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * adapter永远跟集合list,组合在一起
 * 集合里面一般都传bean
 * Created by Qun on 2017/5/2.
 */

public class MainShowAdapter extends FragmentStatePagerAdapter {

    //传入一个集合
    private List<FragmentInfo> mShowItems = new ArrayList<>();

    public MainShowAdapter(FragmentManager fm, List<FragmentInfo> showItems) {
        super(fm);
        mShowItems = showItems;
    }

    //显示一个fragment对象
    @Override
    public Fragment getItem(int position) {
        return mShowItems.get(position).fragment;
    }

    //显示多少个
    @Override
    public int getCount() {
        return mShowItems.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mShowItems.get(position).title;
    }
}
