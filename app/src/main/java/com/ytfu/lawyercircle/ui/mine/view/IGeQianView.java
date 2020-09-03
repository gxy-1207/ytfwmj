package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.GeQianBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/1/6
*
*  @Des 个性签名view
*
*/
public interface IGeQianView extends BaseView {
    void onGqSuccess(GeQianBean geQianBean);
    void onGqFiled();
}
