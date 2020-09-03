package com.ytfu.lawyercircle.ui.falvguwen.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.falvguwen.bean.LegalAdviserDetailsBean;
import com.ytfu.lawyercircle.ui.home.bean.AudioShouCangBean;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.SendEmailBean;
import com.ytfu.lawyercircle.ui.mine.bean.BdEmailBean;
import com.ytfu.lawyercircle.ui.pay.bean.AccountPayResponseBean;
import com.ytfu.lawyercircle.ui.pay.bean.PayBean;
import com.ytfu.lawyercircle.ui.pay.bean.WxPayBean;

public interface ILegalAdviserDetailsView extends BaseView {
    void onSuccess(LegalAdviserDetailsBean xinagQingBean);

    void onFiled(String error);

    void onShouCangSuccess(AudioShouCangBean shouCangBean);

    void onShouCangdelSuccess(AudioShouCangBean shouCangBean);

    void onFlgwPaySuccess(PayBean payBean);

    void onFlgwPayWxSuccess(WxPayBean wxPayBean);

    void onSendEmailSuccess(SendEmailBean emailBean);

    void onFlguBdEmail(BdEmailBean bdEmailBean);
    /** 账户余额支付成功的回调 */
    void onPayByAccountSuccess(AccountPayResponseBean payResponseBean);
}
