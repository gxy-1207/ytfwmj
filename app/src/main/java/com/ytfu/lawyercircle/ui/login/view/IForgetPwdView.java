package com.ytfu.lawyercircle.ui.login.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.login.bean.ForgectDosePwdBean;
import com.ytfu.lawyercircle.ui.login.bean.ForgetSendBean;

public interface IForgetPwdView extends BaseView {
    void onForgetPwdSuccess(ForgetSendBean forgetSendBean);
    void onForgetPweFilded();
    void onForgetDosetPwd(ForgectDosePwdBean dosePwdBean);
}
