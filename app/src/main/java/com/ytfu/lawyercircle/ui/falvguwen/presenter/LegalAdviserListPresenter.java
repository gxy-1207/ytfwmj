package com.ytfu.lawyercircle.ui.falvguwen.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.falvguwen.bean.LegalAdviserListBean;
import com.ytfu.lawyercircle.ui.falvguwen.view.ILegalAdviserListView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
/**
*
*  @Auther  gxy
*
*  @Date    2019/11/22
*
*  @Des  法律顾问列表
*
*/
public class LegalAdviserListPresenter extends BasePresenter<ILegalAdviserListView> {
    private Context mContext;

    public LegalAdviserListPresenter(Context mContext) {
        this.mContext = mContext;
    }
    public void getFlgwLieBiao(HashMap<String,String> map){
        HttpUtil.getInstance().getApiService().getFlgwLb(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<LegalAdviserListBean>() {
                    @Override
                    public void onNextImpl(LegalAdviserListBean entity) {
                        if (AppConstant.STATUS_SUCCESS == entity.getStatus()) {
                           getView().onSuccess(entity);
                        }else{
                            getView().onSuccess(null);
                        }
                    }
                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getFlgwLieBiao" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().showTimeout();
                        getView().onFiled(errorMessage);
                    }
                });
    }
}
