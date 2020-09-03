package com.ytfu.lawyercircle.ui.falvguwen.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.falvguwen.bean.LegalAdviserSecondClassifyBean;

/**
*
*  @Auther  gxy
*
*  @Date    2019/11/22
*
*  @Des  法律顾问二级列表分类
*
*/
public interface ILegalAdviserClassifyView extends BaseView {
        void onSuccess(LegalAdviserSecondClassifyBean secondFenLeiBean);
        void onFiled(String error);
}
