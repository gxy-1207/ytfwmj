package com.ytfu.lawyercircle.ui.lawyer.setting.v;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.InformationBean;

public interface LawyerSettingView extends BaseView {

    void onGetInformationSuccess(InformationBean info);

    void onGetInformationFail(String msg);
}
