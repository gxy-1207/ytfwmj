package com.ytfu.lawyercircle.ui.kaitingzhushou.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.GsjdBean;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.SendEmailBean;
import com.ytfu.lawyercircle.ui.mine.bean.BdEmailBean;

/**
*
*  @Auther  gxy
*
*  @Date    2019/11/27
*
*  @Des  工伤鉴定view
*
*/
public interface IGsjdView extends BaseView {
    void onGsjdSuccess(GsjdBean gsjdBean);
    void onGsjdFiled(String str);
    void onSendEmailSuccess(SendEmailBean emailBean);
    void onGsjdBdEmailSuccess(BdEmailBean bdEmailBean);
}
