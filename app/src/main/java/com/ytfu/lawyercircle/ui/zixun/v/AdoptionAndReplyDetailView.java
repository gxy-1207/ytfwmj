package com.ytfu.lawyercircle.ui.zixun.v;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.zixun.bean.AdoptionBean;
import com.ytfu.lawyercircle.ui.zixun.bean.ReplyDetailBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/6/16
*
*  @Des  评价回复详情和采纳View
*
*/
public interface AdoptionAndReplyDetailView extends BaseView {
    void onReplyDetailsSuccess(ReplyDetailBean replyDetailBean);
    void onAdoptionSuccess(AdoptionBean adoptionBean);
    void onFiled();
}
