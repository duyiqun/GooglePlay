package com.qun.googleplay.viewholder;

import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.DetailBean;
import com.qun.googleplay.downmanager.DownInfo;
import com.qun.googleplay.downmanager.DownManager;
import com.qun.googleplay.global.GooglePlay;

import butterknife.BindView;

/**
 * Created by Qun on 2017/7/16.
 */

public class BottomViewHolder extends BaseViewHolder<DetailBean> implements View.OnClickListener, DownManager.onDownListener {

    @BindView(R.id.pb_bottom_progress)
    ProgressBar mPbBottomProgress;
    @BindView(R.id.bt_bottom_down)
    Button mBtBottomDown;
    private DetailBean mDetailBean;

    @Override
    public View createItemView() {
        View view = View.inflate(GooglePlay.sContext, R.layout.bottomlayout, null);
        return view;
    }

    @Override
    public void bindView(DetailBean detailBean) {
        this.mDetailBean = detailBean;
        mBtBottomDown.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_bottom_down:
//                for (int i = 0; i < 20; i++) {
//                    MyRunnable myRunnable = new MyRunnable(i);
//                    ThreadPoolManager.getInstance().addRunnable(myRunnable);
//                }
                //监听
                DownManager.getInstance().addOnDownListener(this);
                DownManager.getInstance().down(mDetailBean);

                break;
            default:
                break;
        }
    }

    //发布进度
    @Override
    public void publishProgress(DownInfo downInfo) {
        System.out.println("进度" + downInfo.progress);
    }

    @Override
    public void publishState(DownInfo downInfo) {
        System.out.println("当前的状态" + downInfo.downState);
    }

    public class MyRunnable implements Runnable {

        private int point;

        public MyRunnable(int i) {
            this.point = i;
        }

        @Override
        public void run() {
            System.out.println("当前线程开启" + point);
            SystemClock.sleep(3000);
            System.out.println("当前线程结束" + point);
        }
    }
}
