package com.qun.googleplay.exceptionmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.qun.googleplay.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Qun on 2017/7/18.
 */

public class ExceptionDemo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exception);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_exception01, R.id.btn_exception02, R.id.btn_exception03, R.id.btn_exception04})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_exception01:
                try {
                    throw new ExceptionA();
                } catch (Exception exception) {
                    ExceptionManager.getInstance().ShowException(exception);
                    exception.printStackTrace();
                }
                break;
            case R.id.btn_exception02:
                try {
                    throw new ExceptionB();
                } catch (Exception exception) {
                    ExceptionManager.getInstance().ShowException(exception);
                    exception.printStackTrace();
                }
                break;
            case R.id.btn_exception03:
                try {
                    throw new ExceptionC();
                } catch (Exception exception) {
                    ExceptionManager.getInstance().ShowException(exception);
                    exception.printStackTrace();
                }
                break;
            case R.id.btn_exception04:
                try {
                    throw new ExceptionD();
                } catch (Exception exception) {
                    ExceptionManager.getInstance().ShowException(exception);
                    exception.printStackTrace();
                }
                break;
        }
    }
}
