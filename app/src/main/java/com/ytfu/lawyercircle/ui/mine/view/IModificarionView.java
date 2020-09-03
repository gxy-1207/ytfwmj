package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.ModificationBean;
import com.ytfu.lawyercircle.ui.mine.bean.PictureUploadBean;

public interface IModificarionView extends BaseView {
    void onPictureUpLoadSuccess(PictureUploadBean uploadBean);
    void onUploadFiled();
    void onModificartionSuccess(ModificationBean modificationBean);

}
