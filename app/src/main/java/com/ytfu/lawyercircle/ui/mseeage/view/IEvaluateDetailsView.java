package com.ytfu.lawyercircle.ui.mseeage.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mseeage.bean.PingJIaDetailsBean;

public interface IEvaluateDetailsView extends BaseView {
    void onEvaluateDetailsSuccess(PingJIaDetailsBean pingJIaDetailsBean);
    void onEvaluateDetailsFiled();
}
