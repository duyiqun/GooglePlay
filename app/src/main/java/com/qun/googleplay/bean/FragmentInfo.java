package com.qun.googleplay.bean;

import android.support.v4.app.Fragment;

/**
 * Created by Qun on 2017/5/2.
 */

public class FragmentInfo {

    //显示的fragment
    public Fragment fragment;
    //显示title
    public String title;

    public FragmentInfo(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }
}
