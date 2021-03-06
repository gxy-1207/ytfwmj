package com.ytfu.lawyercircle.ui.login.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.login.bean.CodeBean;
import com.ytfu.lawyercircle.ui.login.bean.CodeLoginBean;
import com.ytfu.lawyercircle.ui.login.bean.WxLoginBean;

public interface ICodeView extends BaseView {
    //获取验证码
    void onCodeSuccess(CodeBean codeBean);
    void onCodeFiled();
    //验证码登录
    void onCodeLoginSuccess(CodeLoginBean codeLoginBean);
    //微信登录
    void onWxLoginSuccess(WxLoginBean wxLoginBean);
}
