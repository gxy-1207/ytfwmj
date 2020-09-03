package com.ytfu.lawyercircle.ui.home.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.home.bean.AudioShouCangBean;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.ContractDetailsBean;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.SendEmailBean;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.DownloadPreviewBean;
import com.ytfu.lawyercircle.ui.mine.bean.BdEmailBean;

import com.ytfu.lawyercircle.ui.pay.bean.PayBean;
import com.ytfu.lawyercircle.ui.pay.bean.WxPayBean;


/**
*
*  @Auther  gxy
*
*  @Date    2019/11/12
*
*  @Des 合同详情的view
*
*/
public interface IContractDetailsView extends BaseView {
    void onContractDetailsSuccess(ContractDetailsBean detailsBean);
    void onContractDetailFiled();
    void onShouCangSuccess(AudioShouCangBean shouCangBean);
    void onShouCangdelSuccess(AudioShouCangBean shouCangBean);
    void onContractPaySuccess(PayBean payBean);
    void onContractPayWxSuccess(WxPayBean wxPayBean);
    void onSendEmailSuccess(SendEmailBean emailBean);
    void onContractBdEmailSuccess(BdEmailBean bdEmailBean);
    //统计现在预览次数
    void onDownlodaPreviewSuccess(DownloadPreviewBean previewBean);
}
