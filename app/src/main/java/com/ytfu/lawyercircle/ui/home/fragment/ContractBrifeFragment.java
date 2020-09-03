package com.ytfu.lawyercircle.ui.home.fragment;

import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BaseFragment;
import com.ytfu.lawyercircle.ui.home.bean.AudioShouCangBean;
import com.ytfu.lawyercircle.ui.home.presenter.ContractDetailsPresenter;
import com.ytfu.lawyercircle.ui.home.view.IContractDetailsView;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.SendEmailBean;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.ContractDetailsBean;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.DownloadPreviewBean;
import com.ytfu.lawyercircle.ui.mine.bean.BdEmailBean;
import com.ytfu.lawyercircle.ui.pay.bean.PayBean;
import com.ytfu.lawyercircle.ui.pay.bean.WxPayBean;
import com.ytfu.lawyercircle.utils.SpUtil;

import java.util.HashMap;

/** @Auther gxy @Date 2019/11/13 @Des 合同简介fragment */
public class ContractBrifeFragment
        extends BaseFragment<IContractDetailsView, ContractDetailsPresenter>
        implements IContractDetailsView {
    private TextView tv_audio_brife;
    private String uid;
    private String id;

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_contract_brife;
    }

    @Override
    protected ContractDetailsPresenter createPresenter() {
        return new ContractDetailsPresenter();
    }

    @Override
    protected void initView(View rootView) {
        //        hideLoading();
        tv_audio_brife = rootView.findViewById(R.id.tv_audio_brife);
    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        id = intent.getStringExtra("id");
        uid = SpUtil.getString(mContext, AppConstant.UID, "");
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("id", id);
        getPresenter().getContractDetails(map);
    }

    @Override
    protected void onMyReload(View v) {
        super.onMyReload(v);
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("id", id);
        getPresenter().getContractDetails(map);
    }

    @Override
    public void onContractDetailsSuccess(ContractDetailsBean detailsBean) {
        hideLoading();
        if (detailsBean == null) {
            showEmpty();
        } else {
            String descript = detailsBean.getList().getDescript();
            tv_audio_brife.setText("\u3000\u3000" + Html.fromHtml(descript));
        }
    }

    @Override
    public void onContractDetailFiled() {}

    @Override
    public void onShouCangSuccess(AudioShouCangBean shouCangBean) {
        hideLoading();
    }

    @Override
    public void onShouCangdelSuccess(AudioShouCangBean shouCangBean) {
        hideLoading();
    }

    @Override
    public void onContractPaySuccess(PayBean payBean) {}

    @Override
    public void onContractPayWxSuccess(WxPayBean wxPayBean) {}

    @Override
    public void onSendEmailSuccess(SendEmailBean emailBean) {}

    @Override
    public void onContractBdEmailSuccess(BdEmailBean bdEmailBean) {}

    @Override
    public void onDownlodaPreviewSuccess(DownloadPreviewBean previewBean) {}
}
