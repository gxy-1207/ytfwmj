package com.ytfu.lawyercircle.ui.lawyer.transaction.frament;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.github.lee.annotation.InjectPresenter;
import com.lxj.xpopup.util.XPopupUtils;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BaseRecyclerViewFragment;
import com.ytfu.lawyercircle.base.BaseRefreshView;
import com.ytfu.lawyercircle.ui.lawyer.transaction.adapter.TransactionAdapter;
import com.ytfu.lawyercircle.ui.lawyer.transaction.bean.TransactionResponseBean;
import com.ytfu.lawyercircle.ui.lawyer.transaction.p.TransactionPresenter;
import com.ytfu.lawyercircle.utils.ItemDecoration;
import com.ytfu.lawyercircle.utils.SpUtil;

@InjectPresenter(TransactionPresenter.class)
public class TransactionFragment
        extends BaseRecyclerViewFragment<
                TransactionResponseBean.DataBean,
                BaseRefreshView<TransactionResponseBean.DataBean>,
                TransactionPresenter> {

    public static TransactionFragment newInstance() {
        return new TransactionFragment();
    }

    ///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected BaseQuickAdapter<TransactionResponseBean.DataBean, BaseViewHolder> createAdapter() {
        return new TransactionAdapter();
    }

    @Override
    protected void initData() {
        super.initData();
        // 添加分割线
        int color = Color.parseColor("#F2F2F2");
        int lineHeight = XPopupUtils.dp2px(mContext, .5F);
        addItemDecoration(ItemDecoration.createVertical(color, lineHeight, 0));
    }

    @Override
    protected void onLoadMoreOrRefresh(boolean isLoadMore) {
        if (isLoadMore) {
            currentPage++;
        } else {
            currentPage = 1;
        }
        String uid = SpUtil.getString(mContext, AppConstant.UID, "");
        getPresenter().getTransaction(uid, currentPage, pageSize, isLoadMore);
    }
}
