package com.ytfu.lawyercircle.ui.kaitingzhushou.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.KtzsXqListBean;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.SendEmailBean;
import com.ytfu.lawyercircle.ui.mine.bean.BdEmailBean;

/**
*
*  @Auther  gxy
*
*  @Date    2019/11/24
*
*  @Des  开庭助手详情list  view
*
*/
public interface IKtzsXqListView extends BaseView {
    void onSuccess(KtzsXqListBean xqListBean);
    void onFiled();
    void onSendEmail(SendEmailBean emailBean);
    void onKtzsBdEmail(BdEmailBean bdEmailBean);
}
