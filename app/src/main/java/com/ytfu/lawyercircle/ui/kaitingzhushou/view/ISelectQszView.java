package com.ytfu.lawyercircle.ui.kaitingzhushou.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.AddQszBean;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.SelectZhuShouBean;

/**
*
*  @Auther  gxy
*
*  @Date    2019/11/23
*
*  @Des  开庭助手列表view
*
*/
public interface ISelectQszView extends BaseView {
    void onSelectZhuShouSuccess(SelectZhuShouBean zhuShouBean);
    void onAddQszSuccess(AddQszBean addQszBean);
    void onFiled(String error);
}
