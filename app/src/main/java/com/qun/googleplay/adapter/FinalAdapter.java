package com.qun.googleplay.adapter;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qun.googleplay.interfaces.ItemType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qun on 2017/7/15.
 */

public class FinalAdapter extends BaseAdapter {

    private List<? extends ItemType> mShowItems = new ArrayList<>();
    private int mItemLayout;

    public FinalAdapter(List<? extends ItemType> showItems, int itemLayout, AdapterListener adapterListener) {
        this.mShowItems = showItems;
        this.mItemLayout = itemLayout;
        this.mAdapterListener = adapterListener;
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
        FinalViewHolder finalViewHolder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), mItemLayout, null);
            finalViewHolder = new FinalViewHolder(convertView);
            convertView.setTag(finalViewHolder);
        } else {
            finalViewHolder = (FinalViewHolder) convertView.getTag();
        }

        //赋值
//        finalViewHolder.tvHomeDesc.setText("");
        mAdapterListener.bindView(finalViewHolder, mShowItems.get(position), position);

        return convertView;
    }

    //1.定义接口
    public interface AdapterListener {
        void bindView(FinalViewHolder finalViewHolder, ItemType itemType, int position);
    }

    //2.接收
    private AdapterListener mAdapterListener;

    //3.设置(构造方法或者set方法)

    //4.暴露出去


    public class FinalViewHolder {

//        ImageView ivHomeIcon;
//        TextView tvHomeTitle;
//        RatingBar rbHomeStart;
//        TextView tvHomeSize;
//        TextView tvHomeDesc;

        View mView;

        public FinalViewHolder(View view) {
            this.mView = view;
//            ivHomeIcon = (ImageView) view.findViewById(R.id.iv_home_icon);
//            tvHomeTitle = (TextView) view.findViewById(R.id.tv_home_title);
//            rbHomeStart = (RatingBar) view.findViewById(R.id.rb_home_start);
//            tvHomeSize = (TextView) view.findViewById(R.id.tv_home_size);
//            tvHomeDesc = (TextView) view.findViewById(R.id.tv_home_desc);
        }

//        HashMap<Integer, View> mViews = new HashMap<>();

        //性能高一点
        private SparseArray<View> mViews = new SparseArray<>();

        //根据id自动查找控件
        public View getViewById(int id) {
            View view = mViews.get(id);
            if (view == null) {
                view = mView.findViewById(id);
                mViews.put(id, view);
            }

            //到这里肯定有view
            return view;
        }

        //返回一个textView
        public TextView getTextView(int id) {
            return (TextView) getViewById(id);
        }
    }
}
