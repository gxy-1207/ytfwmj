package com.ytfu.lawyercircle.ui.lvshiwenti.view;

import com.ytfu.lawyercircle.base.BaseRefreshView;
import com.ytfu.lawyercircle.ui.users.bean.ConsultationDetailsBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/6/15
*
*  @Des  咨询详情view
*
*/
public interface LawyerConsultationDetailsView extends BaseRefreshView<ConsultationDetailsBean.XiaoxiArrBean> {

    void onConsultationDetailsSuccess(ConsultationDetailsBean consultationDetailsBean);

}
