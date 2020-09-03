package com.ytfu.lawyercircle.ui.mseeage.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mseeage.bean.TaHuiDaBean;
import com.ytfu.lawyercircle.ui.mseeage.view.ITaDeHuiView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TaHuiDaPresenter extends BasePresenter<ITaDeHuiView> {
    private Context mContext;

    public TaHuiDaPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void getTaHuiDa(String lid,int p){
        HttpUtil.getInstance().getApiService().setTaHuiDa(lid,p)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<TaHuiDaBean>() {
                    @Override
                    public void onNextImpl(TaHuiDaBean taHuiDaBean) {
                        if (taHuiDaBean.getCode() == 200) {
                            getView().onTaHuiSuccess(taHuiDaBean);
                        } else {
                            getView().onTaHuiSuccess(taHuiDaBean);
                        }
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setMessageWatchPay" + errorMessage);
//                        ToastUtil.showToast("网络开小差了");
                        getView().onTaHuiFiled();
                    }
                });
    }
}
