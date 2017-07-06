package com.qun.googleplay.adapter;

import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.HomeBean;
import com.qun.googleplay.global.GooglePlay;

import java.util.ArrayList;
import java.util.List;

/**
 * 把所有可变的都抽取到viewholder中
 * 把T类型放到最后去抽取
 * Created by Qun on 2017/7/4.
 */

public class HomeListAdapter extends BaseAdapter {

    private List<HomeBean.HomeItem> mShowItems = new ArrayList();

    public HomeListAdapter(List<HomeBean.HomeItem> showItems) {
        mShowItems = showItems;
    }

    @Override
    public int getCount() {
        return mShowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mShowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
//            convertView = View.inflate(parent.getContext(), R.layout.item_home, null);
//            viewHolder = new ViewHolder(convertView);
//            viewHolder = new ViewHolder(View.inflate(parent.getContext(), R.layout.item_home, null));
//            viewHolder = new ViewHolder();
//            viewHolder.ivHomeIcon = (ImageView) convertView.findViewById(R.id.iv_home_icon);
//            viewHolder.tvHomeTitle = (TextView) convertView.findViewById(R.id.tv_home_title);
//            viewHolder.rbHomeStart = (RatingBar) convertView.findViewById(R.id.rb_home_start);
//            viewHolder.tvHomeSize = (TextView) convertView.findViewById(R.id.tv_home_size);
//            viewHolder.tvHomeDesc = (TextView) convertView.findViewById(R.id.tv_home_desc);
//            convertView.setTag(viewHolder);
            viewHolder = new ViewHolder();
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //数据绑定(更新)
        viewHolder.tvHomeTitle.setText(mShowItems.get(position).getName());
        viewHolder.rbHomeStart.setRating(mShowItems.get(position).getStars());
        //格式大小
        String fileSize = Formatter.formatFileSize(parent.getContext(), mShowItems.get(position).getSize());
        viewHolder.tvHomeSize.setText(fileSize);
        viewHolder.tvHomeDesc.setText(mShowItems.get(position).getDes());
        return convertView;
    }

    class ViewHolder {

        ImageView ivHomeIcon;
        TextView tvHomeTitle;
        RatingBar rbHomeStart;
        TextView tvHomeSize;
        TextView tvHomeDesc;

        public ViewHolder() {
//        public ViewHolder(View view) {
            View view = View.inflate(GooglePlay.sContext, R.layout.item_home, null);

            //登记证
            view.setTag(this);

            ivHomeIcon = (ImageView) view.findViewById(R.id.iv_home_icon);
            tvHomeTitle = (TextView) view.findViewById(R.id.tv_home_title);
            rbHomeStart = (RatingBar) view.findViewById(R.id.rb_home_start);
            tvHomeSize = (TextView) view.findViewById(R.id.tv_home_size);
            tvHomeDesc = (TextView) view.findViewById(R.id.tv_home_desc);
        }
    }
}
