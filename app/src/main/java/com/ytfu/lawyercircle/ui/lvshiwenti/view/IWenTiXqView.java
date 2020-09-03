package com.ytfu.lawyercircle.ui.lvshiwenti.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lvshiwenti.bean.WenTiXiangQingBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/5/26
*
*  @Des  问题详情view
*
*/
public interface IWenTiXqView extends BaseView {
    void onWenTiXqSuccess(WenTiXiangQingBean wenTiXiangQingBean);
    void onWenTiXqFiled(String error);
}
