package com.qun.googleplay.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.qun.googleplay.R;
import com.qun.googleplay.ui.fragment.DetailFragment;

/**
 * Created by Qun on 2017/7/13.
 */

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        //显示fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_show_layout, new DetailFragment()).commit();
    }
}
