package com.ytfu.lawyercircle.ui.mseeage.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mseeage.bean.CheckWeixinBean;
import com.ytfu.lawyercircle.ui.mseeage.bean.ExChangeWeiXinBean;
import com.ytfu.lawyercircle.ui.mseeage.bean.FirstMessageBean;
import com.ytfu.lawyercircle.ui.mseeage.bean.LvShiCardBean;
import com.ytfu.lawyercircle.ui.mseeage.bean.ToCheckPayBean;
import com.ytfu.lawyercircle.ui.mseeage.bean.WhetherToPayBean;
import com.ytfu.lawyercircle.ui.pay.bean.PayBean;
import com.ytfu.lawyercircle.ui.pay.bean.WxPayBean;

public interface IChatView extends BaseView {
    //判断是否支付
    void onToCheckPaySucccess(ToCheckPayBean checkPayBean);

    //微信支付
    void onMessageWatchPaySucccess(WxPayBean wxPayBean);

    //支付宝支付
    void onMessageAliPaySuccess(PayBean payBean);

    //律师卡片
    void onLvShiCardSuccess(LvShiCardBean lvShiCardBean);

    //第一次发送消息
    void onFirstMessageSuccess(FirstMessageBean messageBean);

    //点击顶部判断是否支付
    void onWhetherToPay(WhetherToPayBean whetherToPayBean);
//判断是否购买过微信
    void onCheckWeiXinSuccess(CheckWeixinBean checkWeixinBean);
    //交换微信
    void onExChangeWx(ExChangeWeiXinBean exChangeWeiXinBean);
    //进入通知
//    void onNoticeSuccess();
    void onChatFiled();
}
