package com.ytfu.lawyercircle.ui.mine.present;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mine.bean.ShangChangLingYuBean;
import com.ytfu.lawyercircle.ui.mine.view.IShanchanglingyuView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
*
*  @Auther  gxy
*
*  @Date    2020/5/21
*
*  @Des  擅长领域presenter
*
*/
public class ShangChangLingYuPresenter extends BasePresenter<IShanchanglingyuView> {
  private Context mContext;

    public ShangChangLingYuPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void getShangChangLingYu(){
        HttpUtil.getInstance().getApiService().setShangChangLingYu()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<ShangChangLingYuBean>() {
                    @Override
                    public void onNextImpl(ShangChangLingYuBean entity) {
                        if (AppConstant.CODE_SUCCESS == entity.getStatus()) {
                            getView().onShangChangLingYuSuccess(entity);
                        } else {
                            getView().onShangChangLingYuSuccess(entity);
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getShangChangLingYu" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().onShangChangLingYuFiled();
                    }
                });
    }
}
