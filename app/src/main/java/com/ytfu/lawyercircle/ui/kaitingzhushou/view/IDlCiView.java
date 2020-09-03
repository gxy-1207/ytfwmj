package com.ytfu.lawyercircle.ui.kaitingzhushou.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.DlcBean;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.DlcSendEmailBean;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.GenerateProxyWordsBean;
import com.ytfu.lawyercircle.ui.mine.bean.BdEmailBean;
import com.ytfu.lawyercircle.ui.pay.bean.PayBean;
import com.ytfu.lawyercircle.ui.pay.bean.WxPayBean;

/** @Auther gxy @Date 2019/12/2 @Des 代理词view */
public interface IDlCiView extends BaseView {
    void onDlcSuccess(DlcBean dlcBean);

    void onDlicFiled();

    void onDlcSendEmailSuccess(DlcSendEmailBean sendEmailBean);

    void onDlcPaySuccess(PayBean payBean);

    void onDlcPayWxSuccess(WxPayBean wxPayBean);

    void onDlcBdEmail(BdEmailBean bdEmailBean);
    // 生成代理词
    void GeneratesProxyWords(GenerateProxyWordsBean generateProxyWordsBean);
}
