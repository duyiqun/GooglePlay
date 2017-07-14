package com.qun.googleplay.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.qun.googleplay.R;
import com.qun.googleplay.ui.fragment.BaseFragment;
import com.qun.googleplay.utils.Fields;

/**
 * Created by Qun on 2017/7/13.
 */

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Class<BaseFragment> classname = (Class) getIntent().getSerializableExtra(Fields.ShowActivity.CLASSNAME);

        //显示fragment
//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_show_layout, new DetailFragment()).commit();

        try {
//            DetailFragment detailFragment = DetailFragment.class.newInstance();

//            Class<DetailFragment> clss = DetailFragment.class;
//            DetailFragment detailFragment = (DetailFragment) clss.newInstance();

            getSupportFragmentManager().beginTransaction().replace(R.id.fl_show_layout, classname.newInstance()).commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
