package com.qun.googleplay;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_root)
    DrawerLayout mActivityRoot;
    private ActionBarDrawerToggle mDrawerToggle;

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
        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mActivityRoot, R.string.open, R.string.close);

        //同步
        mDrawerToggle.syncState();

        //设置监听
        mActivityRoot.addDrawerListener(mDrawerToggle);
    }

    //菜单点击事件
    //记住select
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home://箭头对象
                mDrawerToggle.onOptionsItemSelected(item);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //初始化代码
    private void init() {


    }
}
