package com.ytfu.lawyercircle.ui.mseeage.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mseeage.bean.SuccessAnLiBean;
import com.ytfu.lawyercircle.ui.mseeage.view.ISuccessAnLiView;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SuccessAnLiPresenter extends BasePresenter<ISuccessAnLiView> {
    private Context mContext;

    public SuccessAnLiPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void getSuccessAnli(HashMap<String, String> map) {
        HttpUtil.getInstance().getApiService().setSuccessAnli(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<SuccessAnLiBean>() {
                    @Override
                    public void onNextImpl(SuccessAnLiBean successAnLiBean) {
                        if (successAnLiBean.getCode() == 200) {
                            getView().onAnliSuccess(successAnLiBean);
                        } else {
                            getView().onAnliSuccess(successAnLiBean);
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getToCheckPay" + errorMessage);
//                        ToastUtil.showToast("网络开小差了");
                        getView().onAnLiFiled();
                    }
                });
    }
}
