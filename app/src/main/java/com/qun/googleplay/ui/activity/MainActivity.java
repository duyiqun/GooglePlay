package com.qun.googleplay.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.qun.googleplay.R;
import com.qun.googleplay.adapter.MainShowAdapter;
import com.qun.googleplay.bean.FragmentInfo;
import com.qun.googleplay.ui.fragment.CategoryFragment;
import com.qun.googleplay.ui.fragment.HomeFragment;
import com.qun.googleplay.ui.fragment.HotFragment;
import com.qun.googleplay.ui.fragment.RecommendFragment;
import com.qun.googleplay.ui.fragment.SubjectFragment;
import com.qun.googleplay.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.activity_root)
    DrawerLayout mActivityRoot;
    @BindView(R.id.tab_main_title)
    TabLayout mTabMainTitle;
    @BindView(R.id.vp_main_show_layout)
    ViewPager mVpMainShowLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    //显示的集合
    private List<FragmentInfo> mShowItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        initActionbar();
        init();

//        ViewCompat.animate(mTabMainTitle).rotation(45).setDuration(1000).start();
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

        //初始化代码

        //初始化集合
//        for (int i = 0; i < 5; i++) {
//            FragmentInfo fragmentInfo = new FragmentInfo();
//            fragmentInfo.fragment = new BaseFragment();
//            fragmentInfo.title = "标题" + i;
//            mShowItems.add(fragmentInfo);
//        }

        //如果参数是三个参上的就不要这么写
//        for (int i = 0; i < 5; i++) {
//            mShowItems.add(new FragmentInfo(new BaseFragment(), "标题" + i));
//        }

        String[] titles = Utils.getStringArray(R.array.tab_names);
        mShowItems.add(new FragmentInfo(new HomeFragment(), titles[0]));
        mShowItems.add(new FragmentInfo(new SubjectFragment(), titles[1]));
        mShowItems.add(new FragmentInfo(new RecommendFragment(), titles[2]));
        mShowItems.add(new FragmentInfo(new CategoryFragment(), titles[3]));
        mShowItems.add(new FragmentInfo(new HotFragment(), titles[4]));

        //2.初始化viewpager
        mVpMainShowLayout.setAdapter(new MainShowAdapter(getSupportFragmentManager(), mShowItems));

        //1.页签与viewpager绑定
        mTabMainTitle.setupWithViewPager(mVpMainShowLayout);

        //3.设置tablayout模式
        mTabMainTitle.setTabMode(TabLayout.MODE_FIXED);//均分模式
//        mTabMainTitle.setTabMode(TabLayout.MODE_SCROLLABLE);//滚动模式

        //4.设置字体颜色
        int normalColor = Color.parseColor("#8C8C8C");
        int selectedColor = Color.parseColor(getResources().getString(R.string.blue));
        mTabMainTitle.setTabTextColors(normalColor, selectedColor);

        //5.设置指示器的颜色
        mTabMainTitle.setSelectedTabIndicatorColor(selectedColor);
    }
}
