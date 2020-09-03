package com.ytfu.lawyercircle.ui.home.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.consult.bean.ZiXunNavBean;
import com.ytfu.lawyercircle.ui.home.bean.RandomLawyerResponse;

public interface AdvisoryView extends BaseView {

    void onGetAdvisoryInfo(ZiXunNavBean data);

    /**
     * 进入付费列表界面
     */
    void onGotoPayActivity(String advisoryId, double money);

    /**
     * 进入发布成功之后的列表界面
     */
    void onGotoPostSuccessActivity(String advisoryId);

    void cleanUserInput();


    void onGetRandomLawyers( RandomLawyerResponse.D data);

    void onGetRandomLawyersFail();

}
