package com.ytfu.lawyercircle.ui.lawyer.question.v;


import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lawyer.question.bean.AreaResponseBean;

public interface AreaView extends BaseView {

    void onGetAllAreaSuccess(AreaResponseBean data);

}
