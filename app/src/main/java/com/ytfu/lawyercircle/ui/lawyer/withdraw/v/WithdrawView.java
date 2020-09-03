package com.ytfu.lawyercircle.ui.lawyer.withdraw.v;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lawyer.withdraw.bean.WithdrawResponseBean;

public interface WithdrawView extends BaseView {

    /**
     * 提现成功
     */
    void onWithdrawSuccess(WithdrawResponseBean bean);

    /**
     * 提现失败
     */
    void onWithdrawFail(String errorMsg);

}
