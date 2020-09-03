package com.ytfu.lawyercircle.ui.mseeage.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mseeage.bean.ComplintBean;

public interface ComplaintView extends BaseView {
    void onComplaintSuccess(ComplintBean complintBean);
    void onComplaintFiled();
}
