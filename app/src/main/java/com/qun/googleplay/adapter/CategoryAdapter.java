package com.qun.googleplay.adapter;

import com.qun.googleplay.interfaces.BodyType;
import com.qun.googleplay.interfaces.HeadType;
import com.qun.googleplay.interfaces.ItemType;
import com.qun.googleplay.viewholder.BaseViewHolder;
import com.qun.googleplay.viewholder.BodyViewHolder;
import com.qun.googleplay.viewholder.HeadViewHolder;

import java.util.List;

/**
 * 创建一个categoryAdapter
 * Created by Qun on 2017/7/11.
 */

public class CategoryAdapter extends MyBaseAdapter<ItemType> {

    private List<ItemType> mShowItems;

    public CategoryAdapter(List<ItemType> showItems) {
        super(showItems);
        mShowItems = showItems;
    }

    public static final int HEAD_TYPE = 0;
    public static final int BODY_TYPE = 1;

    //多条目
    @Override
    public int getItemViewType(int position) {
//        if (mShowItems.get(position) instanceof String) {
//            return HEAD_TYPE;
//        } else {
//            return BODY_TYPE;
//        }

        if (mShowItems.get(position) instanceof BodyType) {
            return BODY_TYPE;
        }
        if (mShowItems.get(position) instanceof HeadType) {
            return HEAD_TYPE;
        }
        return BODY_TYPE;
    }

    //几个条目
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public BaseViewHolder createViewHolder(int position) {
        switch (getItemViewType(position)) {
            case HEAD_TYPE:
                return new HeadViewHolder();
            case BODY_TYPE:
                return new BodyViewHolder();
            default:
                break;
        }
        return null;
    }
}
