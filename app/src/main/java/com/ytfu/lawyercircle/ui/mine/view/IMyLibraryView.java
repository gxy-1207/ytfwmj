package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.SendEmailBean;
import com.ytfu.lawyercircle.ui.mine.bean.BdEmailBean;
import com.ytfu.lawyercircle.ui.mine.bean.MyLibraryBean;

public interface IMyLibraryView extends BaseView {
    void onMyLibrarySuccess(MyLibraryBean libraryBean);
    void onFiled();
    void onSendEmail(SendEmailBean emailBean);
    void onLibraryBdEmailSuccess(BdEmailBean bdEmailBean);
}
