package com.qun.googleplay.ui.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.qun.googleplay.R;
import com.qun.googleplay.bean.DetailBean;
import com.qun.googleplay.cachemanager.JsonCacheManager;
import com.qun.googleplay.utils.Uris;
import com.qun.googleplay.utils.Utils;
import com.qun.googleplay.viewholder.SafeViewHolder;
import com.qun.googleplay.viewholder.ShowImageViewHolder;
import com.qun.googleplay.viewholder.TitleViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Qun on 2017/7/13.
 */

public class DetailFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.ll_detail_show_layout)
    LinearLayout mLlDetailShowLayout;
    private TitleViewHolder mTitleViewHolder;
    private SafeViewHolder mSafeViewHolder;
    private ShowImageViewHolder mShowImageViewHolder;

    @Override
    protected View createView() {
        View view = View.inflate(getContext(), R.layout.activity_detail, null);
        unbinder = ButterKnife.bind(this, view);

        //获取对象
//        Bundle bundle = getArguments();
//        mTvDetailShow.setText("当前的数据：" + bundle.getString("abc"));

        init();

        return view;
    }

    private void init() {

        mTitleViewHolder = new TitleViewHolder();
        mLlDetailShowLayout.addView(mTitleViewHolder.getView());

        mSafeViewHolder = new SafeViewHolder();
        mLlDetailShowLayout.addView(mSafeViewHolder.getView());

        mShowImageViewHolder = new ShowImageViewHolder();
        mLlDetailShowLayout.addView(mShowImageViewHolder.getView());
    }

    @Override
    public Object getData() {
        final DetailBean detailBean = JsonCacheManager.getInstance().getDataBean(Uris.DETAIL_ADDRESS + "com.youyuan.yyhl", DetailBean.class);
        if(detailBean==null){
            return null;
        }

        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mTitleViewHolder.bindView(detailBean);
                mSafeViewHolder.bindView(detailBean);
                mShowImageViewHolder.bindView(detailBean);
            }
        });

        return "";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
