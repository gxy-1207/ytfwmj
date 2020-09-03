package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.InformationBean;
import com.ytfu.lawyercircle.ui.mine.bean.PictureUploadBean;
import com.ytfu.lawyercircle.ui.mine.bean.SetBirthdayBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/1/3
*
*  @Des  个人中心
*
*/
public interface IGrzxView extends BaseView {
    void onGrzxSuccess(InformationBean informationBean);
    void onBirthdaySuccess(SetBirthdayBean setBirthdayBean);
    void onPictureUpLoadSuccess(PictureUploadBean uploadBean);
    void onFiled();
}
