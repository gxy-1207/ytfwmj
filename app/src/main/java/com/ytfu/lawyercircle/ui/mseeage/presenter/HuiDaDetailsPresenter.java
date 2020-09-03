package com.ytfu.lawyercircle.ui.mseeage.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mseeage.bean.HuiDaDetailsBean;
import com.ytfu.lawyercircle.ui.mseeage.view.IHuiDaDetailsView;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HuiDaDetailsPresenter extends BasePresenter<IHuiDaDetailsView> {

    private Context mContext;

    public HuiDaDetailsPresenter(Context mContext) {
        this.mContext = mContext;
    }


    public void getHuiDaDetails(HashMap<String,String> map){
        HttpUtil.getInstance().getApiService().setHuiDaDetails(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<HuiDaDetailsBean>() {
                    @Override
                    public void onNextImpl(HuiDaDetailsBean daDetailsBean) {
                        if (daDetailsBean.getCode() == 200) {
                            getView().onHuiDaSuccess(daDetailsBean);
                        } else {
                            getView().onHuiDaSuccess(daDetailsBean);
                        }
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setMessageWatchPay" + errorMessage);
//                        ToastUtil.showToast("网络开小差了");
                        getView().onHuiDaFiled();
                    }
                });
    }
}
