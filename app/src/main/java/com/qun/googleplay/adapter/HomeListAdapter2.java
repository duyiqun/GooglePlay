package com.qun.googleplay.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qun.googleplay.bean.HomeBean;
import com.qun.googleplay.viewholder.HomeViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 把所有可变的都抽取到viewholder中
 * 把T类型放到最后去抽取
 * Created by Qun on 2017/7/4.
 */

public class HomeListAdapter2 extends BaseAdapter {

    private List<HomeBean.HomeItem> mShowItems = new ArrayList();

    public HomeListAdapter2(List<HomeBean.HomeItem> showItems) {
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
        HomeViewHolder viewHolder;
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
            viewHolder = new HomeViewHolder();
        } else {
            viewHolder = (HomeViewHolder) convertView.getTag();
        }
        //数据绑定(更新)
        viewHolder.bindView(mShowItems.get(position));
        return viewHolder.getView();
    }

//    class ViewHolder {
//
//        ImageView ivHomeIcon;
//        TextView tvHomeTitle;
//        RatingBar rbHomeStart;
//        TextView tvHomeSize;
//        TextView tvHomeDesc;
//        View mView;
//
//        public ViewHolder() {
////        public ViewHolder(View view) {
//            View mView = View.inflate(GooglePlay.sContext, R.layout.item_home, null);
//
//            //登记证
//            mView.setTag(this);
//
//            ivHomeIcon = (ImageView) mView.findViewById(R.id.iv_home_icon);
//            tvHomeTitle = (TextView) mView.findViewById(R.id.tv_home_title);
//            rbHomeStart = (RatingBar) mView.findViewById(R.id.rb_home_start);
//            tvHomeSize = (TextView) mView.findViewById(R.id.tv_home_size);
//            tvHomeDesc = (TextView) mView.findViewById(R.id.tv_home_desc);
//        }
//
//        private void bindView(HomeBean.HomeItem homeItem) {
//            tvHomeTitle.setText(homeItem.getName());
//            rbHomeStart.setRating(homeItem.getStars());
//            //格式大小
//            String fileSize = Formatter.formatFileSize(GooglePlay.sContext, homeItem.getSize());
//            tvHomeSize.setText(fileSize);
//            tvHomeDesc.setText(homeItem.getDes());
//        }
//
//        //返回一个view
//        public View getView() {
//            return mView;
//        }
//    }
}
