package com.ytfu.lawyercircle.ui.consult.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.consult.bean.XuanshangFaBuAliBean;
import com.ytfu.lawyercircle.ui.pay.bean.WxPayBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/5/20
*
*  @Des  悬赏发布的view
*
*/
public interface IXuanShangPayView extends BaseView {
    void onXuanShangWatchPaySuccess(WxPayBean wxPayBean);
    void onXuanShangAliPaySuccess(XuanshangFaBuAliBean faBuAliBean);
    void onXuanShangFiled();
}
