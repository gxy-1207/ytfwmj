package com.ytfu.lawyercircle.ui.lvshiwode.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.ClassificationOfCommonWordsBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/7/15
*
*  @Des 常用语管理
*
*/
public interface ManagementCommonWordsView2 extends BaseView {
     void onCategorySuccess(ClassificationOfCommonWordsBean classification);
     void onfiledError(String error);
}
