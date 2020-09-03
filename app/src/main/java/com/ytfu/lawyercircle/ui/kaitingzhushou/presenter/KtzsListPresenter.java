package com.ytfu.lawyercircle.ui.kaitingzhushou.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.kaitingzhushou.bean.KtzsListBean;
import com.ytfu.lawyercircle.ui.kaitingzhushou.view.IKtzsListView;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class KtzsListPresenter extends BasePresenter<IKtzsListView> {
    private Context mContext;

    public KtzsListPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void setKtzsList(HashMap<String,String> map){
        HttpUtil.getInstance().getApiService().getKtzs(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<KtzsListBean>() {
                    @Override
                    public void onNextImpl(KtzsListBean entity) {
                        if (AppConstant.CODE_SUCCESS == entity.getStatus()) {
                            getView().onSuccess(entity);
                        }else{
                            getView().onSuccess(null);
                        }

                    }
                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setKtzsList" + errorMessage);
//                        ToastUtil.showToast("网络开小差了");
                        getView().showTimeout();
                        getView().onFiled(errorMessage);
                    }
                });

    }
}
