package com.ytfu.lawyercircle.ui.lvshiwode.view;


import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.QuestionResponseBean;
import com.ytfu.lawyercircle.ui.mine.bean.MineBean;

/**
 * 律师我的页面的View层
 */
public interface LawyerPersonalView extends BaseView {

    /**
     * 获取成功
     */
    void onGetPersonalSuccess(MineBean loginBean);

    /**
     * 获取失败
     */
    void onGetPersonalFail(String errorMsg);


    void onGetQuestionInfoSuccess(QuestionResponseBean.DataBean data);


}
