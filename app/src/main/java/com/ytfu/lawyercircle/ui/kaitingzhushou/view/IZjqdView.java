package com.ytfu.lawyercircle.ui.kaitingzhushou.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.ZjqdBean;
import com.ytfu.lawyercircle.ui.pay.bean.PayBean;
import com.ytfu.lawyercircle.ui.pay.bean.WxPayBean;

public interface IZjqdView extends BaseView {
    void onZjqdSuccess(ZjqdBean zjqdBean);

    void onZjqdBuySuccess(PayBean payBean);

    void onZjqdBuyWxSuccess(WxPayBean wxPayBean);

    void onZjqdFiled();

    void onCreateProofSuccess(String resultId);
}
