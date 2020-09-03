package com.ytfu.lawyercircle.ui.home.fragment;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BaseFragment;
import com.ytfu.lawyercircle.ui.home.adaper.SimilarContractAdaper;
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
import java.util.List;

/** @Auther gxy @Date 2019/11/13 @Des 同类合同fragment */
public class ContractSimilarFragment
        extends BaseFragment<IContractDetailsView, ContractDetailsPresenter>
        implements IContractDetailsView {
    private RecyclerView recyele_contract;
    private SimilarContractAdaper contractAdaper;
    private String uid;

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_contract_similar;
    }

    @Override
    protected ContractDetailsPresenter createPresenter() {
        return new ContractDetailsPresenter();
    }

    @Override
    protected void initView(View rootView) {
        //        hideLoading();
        recyele_contract = rootView.findViewById(R.id.recyele_contract);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyele_contract.addItemDecoration(
                new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyele_contract.setLayoutManager(layoutManager);
        recyele_contract.setNestedScrollingEnabled(true);
    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");
        uid = SpUtil.getString(mContext, AppConstant.UID, "");
        contractAdaper = new SimilarContractAdaper(getContext());
        recyele_contract.setAdapter(contractAdaper);
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("id", id);
        getPresenter().getContractDetails(map);
    }

    @Override
    public void onContractDetailsSuccess(ContractDetailsBean detailsBean) {
        hideLoading();
        if (detailsBean == null && detailsBean.getContract_list().isEmpty()) {
            showEmpty();
        } else {
            List<ContractDetailsBean.ContractListBean> contract_list =
                    detailsBean.getContract_list();
            contractAdaper.setmList(contract_list);
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
