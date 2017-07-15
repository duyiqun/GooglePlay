package com.qun.googleplay.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;

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

        String title = getIntent().getStringExtra(Fields.ShowActivity.TITLE);

        //获取数据
        Bundle bundleExtra = getIntent().getBundleExtra(Fields.ShowActivity.BUNDLE);

        //显示fragment
//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_show_layout, new DetailFragment()).commit();

        try {
//            DetailFragment detailFragment = DetailFragment.class.newInstance();

//            Class<DetailFragment> clss = DetailFragment.class;
//            DetailFragment detailFragment = (DetailFragment) clss.newInstance();

            BaseFragment baseFragment = classname.newInstance();
            baseFragment.setArguments(bundleExtra);//传递参数

            getSupportFragmentManager().beginTransaction().replace(R.id.fl_show_layout, baseFragment).commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (!TextUtils.isEmpty(title)) {
            initActionBar(title);
        }
    }

    private void initActionBar(String title) {
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setDisplayShowHomeEnabled(true);

        supportActionBar.setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
