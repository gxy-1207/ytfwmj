package com.ytfu.lawyercircle.ui.qisuzhuang.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.qisuzhuang.bean.QszDeleteBean;
import com.ytfu.lawyercircle.ui.qisuzhuang.bean.QszHistoryBean;
import com.ytfu.lawyercircle.ui.qisuzhuang.view.IQszHistoryView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class QszHistoryPresenter extends BasePresenter<IQszHistoryView> {
    private Context mContext;

    public QszHistoryPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void setQszHistory(HashMap<String, String> map) {
        HttpUtil.getInstance().getApiService().getQszHistory(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<QszHistoryBean>() {
                    @Override
                    public void onNextImpl(QszHistoryBean entity) {
                        if (AppConstant.CODE_SUCCESS == entity.getStatus()) {
                            getView().onQszSuccess(entity);
                        } else {
                            getView().onQszSuccess(null);
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setQszHistory" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().showTimeout();
                        getView().onQszFiled();
                    }
                });
    }

    //删除起诉状
    public void setQszDelete(HashMap<String, String> map) {
        HttpUtil.getInstance().getApiService().getQszDel(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<QszDeleteBean>() {
                    @Override
                    public void onNextImpl(QszDeleteBean entity) {
                        if (AppConstant.CODE_SUCCESS == entity.getStatus()) {
                            getView().onQszDelSuccess(entity);
                        } else {
                            getView().showToast("删除失败");
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setQszHistory" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().onQszFiled();
                    }
                });
    }
}
