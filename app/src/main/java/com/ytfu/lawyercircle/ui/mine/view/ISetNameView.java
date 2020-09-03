package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.SetNameBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/1/6
*
*  @Des  修改昵称view
*
*/
public interface ISetNameView extends BaseView {
    void onSetNameSuccess(SetNameBean setNameBean);
    void onSetNameFiled();
}
