package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.LvShiRenZhengCommitBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/5/22
*
*  @Des  律师认证提交view
*
*/
public interface ILvShiRenZhengCommitView extends BaseView {
    void onLvShiCommitSuccess(LvShiRenZhengCommitBean lvShiRenZhengCommitBean);
    void onLvShiCommitFiled();
}
