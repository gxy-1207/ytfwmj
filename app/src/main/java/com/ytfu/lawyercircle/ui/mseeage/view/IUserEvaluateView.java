package com.ytfu.lawyercircle.ui.mseeage.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mseeage.bean.UserEvaluateBean;
import com.ytfu.lawyercircle.ui.mseeage.bean.UserEvaluateClassBean;

public interface IUserEvaluateView extends BaseView {
    void onUserEvaluateSuccess(UserEvaluateBean userEvaluateBean);
    void onUserEvaluateClassSuccess(UserEvaluateClassBean userEvaluateClassBean);
    void onUserEvaluateFiled();
}
