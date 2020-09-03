package com.ytfu.lawyercircle.ui.kaitingzhushou.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.QylxtgBean;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.SendEmailBean;
import com.ytfu.lawyercircle.ui.mine.bean.BdEmailBean;

/**
*
*  @Auther  gxy
*
*  @Date    2019/11/27
*
*  @Des  企业另需提供
*
*/
public interface IQylxtgView extends BaseView {
    void onQylxtgSuccess(QylxtgBean qylxtgBean);
    void onQylxtgFiled(String str);
    void onSendEmail(SendEmailBean emailBean);
    void onBdEmailSuccess(BdEmailBean bdEmailBean);
}
