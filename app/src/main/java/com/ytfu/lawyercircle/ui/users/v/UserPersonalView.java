package com.ytfu.lawyercircle.ui.users.v;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lawyer.wallet.bean.WalletResponseBean;
import com.ytfu.lawyercircle.ui.mine.bean.MineBean;
import com.ytfu.lawyercircle.ui.mine.bean.ShenHeJInduBean;
import com.ytfu.lawyercircle.ui.users.bean.RefundButtonVisibleBean;

public interface UserPersonalView extends BaseView {


    void onGetInfoSuccess(MineBean.FindBean bean);

    void onGetInfoFail(String errorMsg);
    //===Desc:================================================================================

    void onGetAuthInfo(ShenHeJInduBean bean);

    void onGetAccountBalance(double balance);

    //===Desc:================================================================================


    void onGetWalletInfoSuccess(WalletResponseBean bean);

    void onRefundButtonVisibleSuccess(RefundButtonVisibleBean visibleBean);

    void onGetWalletInfoFail(String errorMsg);

}
