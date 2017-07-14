package com.qun.googleplay.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.qun.googleplay.R;
import com.qun.googleplay.ui.fragment.DetailFragment;

/**
 * Created by Qun on 2017/7/13.
 */

public class ShowActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show2);

        Intent intent = getIntent();

        //邮包
        intent.putExtra("bundle", new Bundle());

        Class clss = DetailFragment.class;
        try {
            DetailFragment object = (DetailFragment) clss.newInstance();

            object.setArguments(new Bundle());

            getSupportFragmentManager().beginTransaction().replace(R.id.fl_show2_layout, object).commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
