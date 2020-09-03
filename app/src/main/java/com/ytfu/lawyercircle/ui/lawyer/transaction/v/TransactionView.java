package com.ytfu.lawyercircle.ui.lawyer.transaction.v;


import com.ytfu.lawyercircle.base.BaseRefreshView;
import com.ytfu.lawyercircle.ui.lawyer.transaction.bean.TransactionResponseBean;

public interface TransactionView extends BaseRefreshView<TransactionResponseBean.DataBean> {

    void onGetTransactionSuccess(TransactionResponseBean bean);

    void onGetTransactionFail(String msg);


}
