package com.ytfu.lawyercircle.ui.home.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.ContractDatalistBean;
import com.ytfu.lawyercircle.ui.home.view.IContractDataListView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ContractDataListPresenter extends BasePresenter<IContractDataListView> {
    private Context mContext;

    public ContractDataListPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void getDataList(HashMap<String,String> map){
        HttpUtil.getInstance().getApiService().getDataList(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<ContractDatalistBean>() {
                    @Override
                    public void onNextImpl(ContractDatalistBean detailsBean) {
                        if(AppConstant.CODE_SUCCESS == detailsBean.getStatus()){
                            getView().onDataListSuccess(detailsBean);
                        }else{
                            getView().onDataListSuccess(null);
                        }
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getDataList" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().onFiled();
                    }
                });
    }
}
