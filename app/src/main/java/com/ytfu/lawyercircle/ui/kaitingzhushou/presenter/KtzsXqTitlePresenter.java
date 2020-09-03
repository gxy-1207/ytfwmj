package com.ytfu.lawyercircle.ui.kaitingzhushou.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.KtzsXqTitleBean;
import com.ytfu.lawyercircle.ui.kaitingzhushou.view.IKtzsXqTitleView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class KtzsXqTitlePresenter extends BasePresenter<IKtzsXqTitleView> {
    private Context mContext;

    public KtzsXqTitlePresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void setKtzsXqTitle(String id) {
        HttpUtil.getInstance().getApiService().getKtzsXqTitle(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<KtzsXqTitleBean>() {
                    @Override
                    public void onNextImpl(KtzsXqTitleBean titleBean) {
                        if(AppConstant.CODE_SUCCESS == titleBean.getStatus()){
                            getView().onSuccess(titleBean);
                        }else{
                            getView().onSuccess(null);
                        }
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setKtzsXqTitle" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().onFiled();
                    }
                });
    }
}
