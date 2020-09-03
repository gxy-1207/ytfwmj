package com.ytfu.lawyercircle.ui.mseeage.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mseeage.bean.LvShiDetailsBean1;
import com.ytfu.lawyercircle.ui.mseeage.view.ILvShiDetailsView;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LvShiDetailsPresent extends BasePresenter<ILvShiDetailsView> {
    private Context mContext;

    public LvShiDetailsPresent(Context mContext) {
        this.mContext = mContext;
    }

    public void getLvShiDetails(HashMap<String,String> map){
        HttpUtil.getInstance().getApiService().setLvShiDetails(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<LvShiDetailsBean1>() {
                    @Override
                    public void onNextImpl(LvShiDetailsBean1 lvShiDetailsBean) {
                        if (lvShiDetailsBean.getCode() == 200) {
                            getView().onLvShiDetailsSuccess(lvShiDetailsBean);
                        } else {
                            getView().onLvShiDetailsSuccess(lvShiDetailsBean);
                        }
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setMessageWatchPay" + errorMessage);
//                        ToastUtil.showToast("网络开小差了");
                        getView().onLvShiDetailsFiled();
                    }
                });
    }
}
