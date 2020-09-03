package com.ytfu.lawyercircle.ui.users.fragment;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.github.lee.annotation.InjectPresenter;
import com.lxj.xpopup.util.XPopupUtils;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BaseRecyclerViewFragment;
import com.ytfu.lawyercircle.base.BaseRefreshView;
import com.ytfu.lawyercircle.ui.users.adaper.MyRefundAdaper;
import com.ytfu.lawyercircle.ui.users.bean.MyRefundBean;
import com.ytfu.lawyercircle.ui.users.p.MyRefundPresenter;
import com.ytfu.lawyercircle.utils.CommonUtil;
import com.ytfu.lawyercircle.utils.ItemDecoration;
import com.ytfu.lawyercircle.utils.SpUtil;

/** @Auther gxy @Date 2020/7/23 @Des 我的退款 */
@InjectPresenter(MyRefundPresenter.class)
public class MyRefundFragment
        extends BaseRecyclerViewFragment<
                MyRefundBean.DataBean, BaseRefreshView<MyRefundBean.DataBean>, MyRefundPresenter> {

    public static MyRefundFragment newInstance() {

        Bundle args = new Bundle();

        MyRefundFragment fragment = new MyRefundFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initData() {
        super.initData();
        enableLoadMore(false);
        int padding = XPopupUtils.dp2px(mContext, 0);
        int height = XPopupUtils.dp2px(mContext, 0.5f);
        addItemDecoration(
                ItemDecoration.createVertical(
                        CommonUtil.getColor(R.color.textColor_E5E5E5), height, padding));
    }

    @Override
    protected BaseQuickAdapter<MyRefundBean.DataBean, BaseViewHolder> createAdapter() {
        return new MyRefundAdaper();
    }

    @Override
    protected void onLoadMoreOrRefresh(boolean isLoadMore) {
        String UserID = SpUtil.getString(mContext, AppConstant.UID, "");
        getPresenter().getMyRefundList(UserID);
    }
}
