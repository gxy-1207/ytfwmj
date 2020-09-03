package com.ytfu.lawyercircle.ui.lvshiwenti.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lvshiwenti.bean.LvShiZiXunListBean;

/**
 * @Auther gxy
 * @Date 2020/5/25
 * @Des 律师端 问题列表view
 */
public interface IlvshiZiXunListView extends BaseView {
    void onLvShiListSuccess(LvShiZiXunListBean lvShiZiXunListBean);

    void onLvShiListFiled(String error);
}
