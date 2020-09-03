package com.ytfu.lawyercircle.ui.qisuzhuang.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.qisuzhuang.bean.QszDeleteBean;
import com.ytfu.lawyercircle.ui.qisuzhuang.bean.QszHistoryBean;

/**
*
*  @Auther  gxy
*
*  @Date    2019/12/17
*
*  @Des  起诉张列表
*
*/
public interface IQszHistoryView extends BaseView {
    void onQszSuccess(QszHistoryBean historyBean);
    void onQszDelSuccess(QszDeleteBean deleteBean);
    void onQszFiled();
}
