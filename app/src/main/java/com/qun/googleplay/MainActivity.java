package com.qun.googleplay;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_root)
    DrawerLayout mActivityRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initActionbar();
        init();
    }

    //actionbar初始化永远都这么写
    private void initActionbar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("GooglePlay");

        //显示箭头--->home
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //箭头对象
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, mActivityRoot, R.string.open, R.string.close);

    }

    //初始化代码
    private void init() {


    }
}
