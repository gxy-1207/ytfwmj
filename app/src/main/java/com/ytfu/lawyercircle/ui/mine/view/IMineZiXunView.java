package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.MineZiXunBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/5/19
*
*  @Des 我的咨询view
*
*/
public interface IMineZiXunView extends BaseView {
    void onMineZiXunSuccess(MineZiXunBean mineZiXunBean);
    void onMineZiXunFiled();
}
