package com.ytfu.lawyercircle.ui.topup.v;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.pay.bean.WxPayBean;

public interface TopUpView extends BaseView {

    void onTopUpWechatSuccess(WxPayBean.SignBean sign);
    void onTopUpAliSuccess(String sign);
}
