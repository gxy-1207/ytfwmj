package com.ytfu.lawyercircle.ui.mseeage.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mseeage.bean.PingJIaDetailsBean;
import com.ytfu.lawyercircle.ui.mseeage.view.IEvaluateDetailsView;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class EvaluateDetailsPresenter extends BasePresenter<IEvaluateDetailsView> {
    private Context mContext;

    public EvaluateDetailsPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void getEvaluateDetalis(HashMap<String,String> map){
        HttpUtil.getInstance().getApiService().setEvaluateDetails(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<PingJIaDetailsBean>() {
                    @Override
                    public void onNextImpl(PingJIaDetailsBean pingJIaDetailsBean) {
                        if (pingJIaDetailsBean.getCode() == 200) {
                            getView().onEvaluateDetailsSuccess(pingJIaDetailsBean);
                        } else {
                            getView().onEvaluateDetailsSuccess(pingJIaDetailsBean);
                        }
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setMessageWatchPay" + errorMessage);
//                        ToastUtil.showToast("网络开小差了");
                        getView().onEvaluateDetailsFiled();
                    }
                });
    }
}
