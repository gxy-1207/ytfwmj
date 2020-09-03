package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.InvitationRecordListBean;
/**
*
*  @Auther  gxy
*
*  @Date    2019/11/17
*
*  @Des  邀请记录view
*
*/
public interface IInvitionRecordView extends BaseView {
    void onInvitionSuccess(InvitationRecordListBean listBean);
    void onFiled();
}
