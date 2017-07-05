package com.qun.googleplay.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.SubjectBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qun on 2017/7/5.
 */

public class SubjectListAdapter extends BaseAdapter {

    private List<SubjectBean> mShowItems = new ArrayList();

    public SubjectListAdapter(List<SubjectBean> showItems) {
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
        SubjectViewHolder subjectViewHolder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.adapter_subject, null);
            subjectViewHolder = new SubjectViewHolder(convertView);
            convertView.setTag(subjectViewHolder);
        } else {
            subjectViewHolder = (SubjectViewHolder) convertView.getTag();
        }

        //赋值
        subjectViewHolder.tvDes.setText(mShowItems.get(position).getDes());
        return convertView;
    }

    class SubjectViewHolder {

        ImageView ivImage;
        TextView tvDes;

        public SubjectViewHolder(View view) {
            ivImage = (ImageView) view.findViewById(R.id.iv_image);
            tvDes = (TextView) view.findViewById(R.id.tv_des);
        }
    }
}
