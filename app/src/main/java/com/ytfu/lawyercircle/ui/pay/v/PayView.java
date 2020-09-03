package com.ytfu.lawyercircle.ui.pay.v;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.pay.bean.AccountInfoBean;

public interface PayView extends BaseView {

    void onGetAdvisoryInfoSuccess(AccountInfoBean data);

    /**唤起支付宝支付*/
    void onAwakeAli(String sign);

    /**账户余额支付成功的回调*/
    void onPayByAccountSuccess();

}
