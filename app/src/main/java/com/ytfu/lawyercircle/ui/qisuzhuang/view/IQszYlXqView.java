package com.ytfu.lawyercircle.ui.qisuzhuang.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.SendEmailBean;
import com.ytfu.lawyercircle.ui.mine.bean.BdEmailBean;

public interface IQszYlXqView extends BaseView {
    void onQszYlXqSendEmail(SendEmailBean sendEmailBean);
    void onQszYlXqBdEmailSuccess(BdEmailBean bdEmailBean);
    void onFiled();
}
