package com.ytfu.lawyercircle.ui.qisuzhuang.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.qisuzhuang.bean.AddZjqdBean;
import com.ytfu.lawyercircle.ui.qisuzhuang.view.IAddZjqdView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther gxy
 * @Date 2019/12/18
 * @Des 添加证据清单persenter
 */
public class AddZjqdPresenter extends BasePresenter<IAddZjqdView> {
    private Context mContext;

    public AddZjqdPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void setAddZjqd(HashMap<String, String> map) {
        HttpUtil.getInstance().getApiService().getAddZjqd(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<AddZjqdBean>() {
                    @Override
                    public void onNextImpl(AddZjqdBean entity) {
                        if (AppConstant.STATUS_SUCCESS == entity.getStatus()) {
                            getView().onAssSuccess(entity);
                        } else {
                            getView().onAssSuccess(null);
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setQszXqFl" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().showTimeout();
                        getView().onAddFiled();
                    }
                });
    }
}
