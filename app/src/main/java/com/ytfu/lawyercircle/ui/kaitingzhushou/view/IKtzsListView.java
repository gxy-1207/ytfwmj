package com.ytfu.lawyercircle.ui.kaitingzhushou.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.KtzsListBean;

/**
*
*  @Auther  gxy
*
*  @Date    2019/11/23
*
*  @Des  开庭助手列表view
*
*/
public interface IKtzsListView extends BaseView {
    void onSuccess(KtzsListBean listBean);
    void onFiled(String error);
}
