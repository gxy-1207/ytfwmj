package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.SetPwdBean;
/**
*
*  @Auther  gxy
*
*  @Date    2020/1/7
*
*  @Des 设置密码view
*
*/
public interface ISetPwdView extends BaseView {
    void onSetPwdSuccess(SetPwdBean setPwdBean);
    void onSetPwdFiled();
}
