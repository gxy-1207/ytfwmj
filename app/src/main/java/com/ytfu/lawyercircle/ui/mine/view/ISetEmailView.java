package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.SetEmailBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/1/6
*
*  @Des 修改邮箱view
*
*/
public interface ISetEmailView extends BaseView {
    void onSetEmailSuccess(SetEmailBean setEmailBean);
    void onSetEmailFiled();
}
