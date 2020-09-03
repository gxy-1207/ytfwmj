package com.ytfu.lawyercircle.ui.login.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.login.bean.LoginPwdBean;

/**
*
*  @Auther  gxy
*
*  @Date    2019/11/15
*
*  @Des 账号密码登录view
*
*/
public interface INumPwdView extends BaseView {
    void onNumPwdSuccess(LoginPwdBean pwdBean);
    void onNumPwdFiled();
}
