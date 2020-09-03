package com.ytfu.lawyercircle.ui.mseeage.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mseeage.bean.TaHuiDaBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/4/20
*
*  @Des Ta的回答view
*
*/
public interface ITaDeHuiView extends BaseView {
    void onTaHuiSuccess(TaHuiDaBean taHuiDaBean);
    void onTaHuiFiled();

}
