package com.qun.googleplay.ui.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.cachemanager.JsonCacheManager;
import com.qun.googleplay.ui.view.randomlayout.StellarMap;
import com.qun.googleplay.utils.Uris;
import com.qun.googleplay.utils.Utils;

import java.util.List;
import java.util.Random;

/**
 * Created by Qun on 2017/7/11.
 */

public class RecommendFragment extends BaseFragment {

    private StellarMap mStellarMap;

    @Override
    protected View createView() {
        mStellarMap = new StellarMap(getContext());

        return mStellarMap;
    }

    //得到一个随机的字体大小
    //14-24
    private float getRandomSize() {
        Random random = new Random();
        return random.nextInt(10) + 14;
    }

    //得到随机颜色
    //颜色范围
    private int getRandomColor() {

        int red = getRandomColorInt();
        int green = getRandomColorInt();
        int blue = getRandomColorInt();
        return Color.rgb(red, green, blue);
    }

    //得到一个随机颜色值
    //0-255
    private int getRandomColorInt() {
        Random random = new Random();
        return random.nextInt(180);
    }

    @Override
    public Object getData() {
        final List<String> stringList = JsonCacheManager.getInstance().getDataList(Uris.RECOMMEND_ADDRESS, String.class);

        if (stringList == null || stringList.size() == 0) {
            return null;
        }

        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                //设置数据适配
                mStellarMap.setAdapter(new StellarMap.Adapter() {
                    //组数
                    @Override
                    public int getGroupCount() {
                        return 3;
                    }

                    //每组多少个
                    @Override
                    public int getCount(int group) {
                        return 11;
                    }

                    //返回一个view
                    @Override
                    public View getView(int group, int position, View convertView) {

                        int index = group * getCount(group) + position;

                        TextView textView = new TextView(getContext());
                        textView.setText(stringList.get(index));
                        //设置颜色
                        textView.setTextColor(getRandomColor());

                        //设置字体的大小
                        textView.setTextSize(getRandomSize());

                        return textView;
                    }

                    //用不到
                    @Override
                    public int getNextGroupOnPan(int group, float degree) {
                        return 0;
                    }

                    @Override
                    public int getNextGroupOnZoom(int group, boolean isZoomIn) {
                        //0-->1-->2-->3
                        int index = (group + 1) % 3;
                        return index;
                    }
                });

                //设置第一组可见
                mStellarMap.setGroup(0, true);
                mStellarMap.setRegularity(11, 11);//设置格子
                //设置边距
                int dp10 = Utils.getDimens(R.dimen.dp10);
                mStellarMap.setInnerPadding(dp10, dp10, dp10, dp10);
            }
        });

        return stringList;
    }
}
