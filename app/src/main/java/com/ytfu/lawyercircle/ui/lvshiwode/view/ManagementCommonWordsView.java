package com.ytfu.lawyercircle.ui.lvshiwode.view;

import com.ytfu.lawyercircle.base.BaseRefreshView;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.CommonWordsListBean;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.EditDeleteCommonWordsBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/7/15
*
*  @Des 常用语管理
*
*/
public interface ManagementCommonWordsView extends BaseRefreshView<CommonWordsListBean.DataBean> {
     void onDelSuccess(EditDeleteCommonWordsBean deleteCommonWordsBean);
     void onfiledError(String error);
}
