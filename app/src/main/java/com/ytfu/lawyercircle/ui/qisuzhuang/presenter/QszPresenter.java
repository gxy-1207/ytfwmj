package com.ytfu.lawyercircle.ui.qisuzhuang.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.qisuzhuang.bean.QszFenLeiBean;
import com.ytfu.lawyercircle.ui.qisuzhuang.view.IQszView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class QszPresenter extends BasePresenter<IQszView> {
    private Context mContext;

    public QszPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void getQiSuZhuang() {
        HttpUtil.getInstance().getApiService().getQsz()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<QszFenLeiBean>() {
                    @Override
                    public void onNextImpl(QszFenLeiBean entity) {
                        if (AppConstant.CODE_SUCCESS == entity.getStatus()) {
                            getView().onQszSuccess(entity);
                        } else {
                            getView().onQszSuccess(null);
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getQiSuZhuang" + errorMessage);
//                        ToastUtil.showToast("网络开小差了");
                        getView().showTimeout();
                        getView().onQszFiled();
                    }
                });
    }
}
