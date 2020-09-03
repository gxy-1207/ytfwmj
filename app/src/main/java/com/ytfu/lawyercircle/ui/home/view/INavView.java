package com.ytfu.lawyercircle.ui.home.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.home.bean.AudioNavBean;

/**
*
*  @Auther  gxy
*
*  @Date    2019/11/13
*
*  @Des  音频标题view
*
*/
public interface INavView extends BaseView {
    void onNavSuccess(AudioNavBean navBean);
    void onNavFalied();

}
