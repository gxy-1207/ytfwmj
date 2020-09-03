package com.ytfu.lawyercircle.ui.mseeage.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.chat.bean.LawyerListBean;
import com.ytfu.lawyercircle.ui.mseeage.bean.ConversationBean;
import com.ytfu.lawyercircle.ui.mseeage.bean.LvShiCardBean;

import java.util.List;

public interface IConversationView extends BaseView {
    void onCoversationSuccess(ConversationBean conversationBean);

    //律师卡片
    void onLvShiCardSuccess(LvShiCardBean lvShiCardBean);
    void onConversationFiled();


    void onGetLawyerChatListSuccess(List<LawyerListBean.LawyerItemBean> data);

    void onGetLawyerChatListFail(String msg);


}
