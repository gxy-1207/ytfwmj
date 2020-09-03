package com.ytfu.lawyercircle.ui.home.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.home.bean.AudioDetailsBean;
import com.ytfu.lawyercircle.ui.home.bean.AudioListerBean;
import com.ytfu.lawyercircle.ui.home.bean.AudioShouCangBean;
import com.ytfu.lawyercircle.ui.pay.bean.PayBean;
import com.ytfu.lawyercircle.ui.pay.bean.WxPayBean;


/**
*
*  @Auther  gxy
*
*  @Date    2019/11/12
*
*  @Des 音频详情的view
*
*/
public interface IAudioDetailsView extends BaseView {
    void onDetailsSuccess(AudioDetailsBean detailsBean);
    void onDetailFiled();
    void onShouCangSuccess(AudioShouCangBean shouCangBean);
    void onShouCangdelSuccess(AudioShouCangBean shouCangBean);
    void onAudioPaySuccess(PayBean payBean);
    void onAudioPayWxSuccess(WxPayBean wxPayBean);
    void onListenerSuccess(AudioListerBean listerBean);
}
