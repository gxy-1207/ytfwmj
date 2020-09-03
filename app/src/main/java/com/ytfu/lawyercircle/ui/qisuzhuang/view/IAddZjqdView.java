package com.ytfu.lawyercircle.ui.qisuzhuang.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.qisuzhuang.bean.AddZjqdBean;

/**
*
*  @Auther  gxy
*
*  @Date    2019/12/18
*
*  @Des  添加证据清单view
*
*/
public interface IAddZjqdView extends BaseView {
    void onAssSuccess(AddZjqdBean zjqdBean);
    void onAddFiled();
}
