package com.ytfu.lawyercircle.ui.users.v;

import com.ytfu.lawyercircle.base.BaseView;
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
public interface ConsultationDetailsView2 extends BaseView {

    void onConsultationDetailsSuccess(ConsultationDetailsBean consultationDetailsBean);
//    /**唤起支付宝支付*/
//    void onAwakeAli(String sign);
//
//    /**账户余额支付成功的回调*/
//    void onPayByAccountSuccess(AccountPayResponseBean payResponseBean);
    void onConsultationDetailsFiled();
}
