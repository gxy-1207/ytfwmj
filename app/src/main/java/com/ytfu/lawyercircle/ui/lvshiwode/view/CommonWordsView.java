package com.ytfu.lawyercircle.ui.lvshiwode.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.AddCommonWordsBean;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.ClassificationOfCommonWordsBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/7/14
*
*  @Des 常用语v
*
*/
public interface CommonWordsView extends BaseView {
    void onAddCommonWordsSuccess(AddCommonWordsBean addCommonWordsBean);
    void onAddCommonWordsFiled(String errorMsg);
    void onClassificationOfCommonWordsSuccess(ClassificationOfCommonWordsBean classificationOfCommonWordsBean);
}
