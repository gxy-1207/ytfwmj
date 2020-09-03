package com.ytfu.lawyercircle.ui.lvshiwode.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.EditDeleteCommonWordsBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/7/14
*
*  @Des 常用语v
*
*/
public interface EditCommonWordsView extends BaseView {
    void onEditCommonWordsSuccess(EditDeleteCommonWordsBean deleteCommonWordsBean);
    void onEditCommonWordsFiled(String errorMsg);
}
