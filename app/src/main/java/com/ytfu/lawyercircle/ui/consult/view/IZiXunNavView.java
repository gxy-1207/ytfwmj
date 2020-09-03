package com.ytfu.lawyercircle.ui.consult.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.consult.bean.MIanFeiFaBuBean;
import com.ytfu.lawyercircle.ui.consult.bean.ZiXunNavBean;

public interface IZiXunNavView extends BaseView {
    //咨询分类
    void onZiXunNavSuccess(ZiXunNavBean ziXunNavBean);
    //免费发布
    void onMianFeiFaBuSuccess(MIanFeiFaBuBean mIanFeiFaBuBean);
    void onZiXunNavFiled();
}
