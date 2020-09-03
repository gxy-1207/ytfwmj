package com.ytfu.lawyercircle.ui.home.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.ContractListSecondBean;
import com.ytfu.lawyercircle.ui.home.view.IContractListSecondView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ContractListSecondPresenter extends BasePresenter<IContractListSecondView> {
    private Context mContext;

    public ContractListSecondPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void secondList(String id){
        HttpUtil.getInstance().getApiService().getListSecond(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<ContractListSecondBean>() {
                    @Override
                    public void onNextImpl(ContractListSecondBean resultEntity) {
                        if (AppConstant.CODE_SUCCESS == resultEntity.getStatus()) {
                            getView().onSecondListSuccess(resultEntity);
                        }else{
                            getView().onSecondListSuccess(null);
                        }
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("secondList" + errorMessage);
                        ToastUtil.showToast("网络错误");
                        getView().onFiled();
                    }
                });
    }
}
