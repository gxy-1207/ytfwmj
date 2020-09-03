package com.ytfu.lawyercircle.ui.falvguwen.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.falvguwen.bean.LegalAdviserListBean;
/**
*
*  @Auther  gxy
*
*  @Date    2019/11/22
*
*  @Des  法律顾问列表view
*
*/
public interface ILegalAdviserListView extends BaseView {
    void onSuccess(LegalAdviserListBean liebiaoBean);
    void onFiled(String errorMessage);
}
