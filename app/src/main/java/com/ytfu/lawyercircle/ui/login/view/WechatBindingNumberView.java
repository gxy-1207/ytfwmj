package com.ytfu.lawyercircle.ui.login.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.login.bean.CodeBean;
import com.ytfu.lawyercircle.ui.login.bean.WechatBindingnumBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/7/8
*
*  @Des  微信登录绑定手机号
*
*/
public interface WechatBindingNumberView extends BaseView {
    void onBindingSuccess(CodeBean codeBean);
    void onBindingMobileSuccess(WechatBindingnumBean wechatBindingnumBean);
    void onBindngFiled();
} 