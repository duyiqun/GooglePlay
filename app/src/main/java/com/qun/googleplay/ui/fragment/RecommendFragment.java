package com.qun.googleplay.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.ui.view.randomlayout.StellarMap;
import com.qun.googleplay.utils.Utils;

/**
 * Created by Qun on 2017/7/11.
 */

public class RecommendFragment extends BaseFragment {

    @Override
    protected View createView() {
        StellarMap stellarMap = new StellarMap(getContext());

        //设置数据适配
        stellarMap.setAdapter(new StellarMap.Adapter() {
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
                textView.setText("当前个数：" + index);
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
        stellarMap.setGroup(0, true);
        stellarMap.setRegularity(11, 11);//设置格子
        //设置边距
        int dp10 = Utils.getDimens(R.dimen.dp10);
        stellarMap.setInnerPadding(dp10, dp10, dp10, dp10);

        return stellarMap;
    }

    @Override
    public Object getData() {
        return "";
    }
}
