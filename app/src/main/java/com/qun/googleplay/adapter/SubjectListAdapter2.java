package com.qun.googleplay.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qun.googleplay.bean.SubjectBean;
import com.qun.googleplay.viewholder.SubjectViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qun on 2017/7/5.
 */

public class SubjectListAdapter2 extends BaseAdapter {

    private List<SubjectBean> mShowItems = new ArrayList();

    public SubjectListAdapter2(List<SubjectBean> showItems) {
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
//            convertView = View.inflate(parent.getContext(), R.layout.adapter_subject, null);
//            subjectViewHolder = new SubjectViewHolder(convertView);
//            convertView.setTag(subjectViewHolder);
            subjectViewHolder = new SubjectViewHolder();
        } else {
            subjectViewHolder = (SubjectViewHolder) convertView.getTag();
        }

        //赋值
        subjectViewHolder.bindView(mShowItems.get(position));
        return subjectViewHolder.getView();
    }

//    class SubjectViewHolder {
//
//        ImageView ivImage;
//        TextView tvDes;
//        View mView;
//
//        public SubjectViewHolder() {
//            mView = View.inflate(GooglePlay.sContext, R.layout.adapter_subject, null);
//
//            mView.setTag(this);
//
//            ivImage = (ImageView) mView.findViewById(R.id.iv_image);
//            tvDes = (TextView) mView.findViewById(R.id.tv_des);
//        }
//
//        public void bindView(SubjectBean subjectBean) {
//            tvDes.setText(subjectBean.getDes());
//        }
//
//        //返回一个view
//        public View getView() {
//            return mView;
//        }
//    }
}
