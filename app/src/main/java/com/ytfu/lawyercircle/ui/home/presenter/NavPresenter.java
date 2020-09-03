package com.ytfu.lawyercircle.ui.home.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.home.bean.AudioNavBean;
import com.ytfu.lawyercircle.ui.home.view.INavView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
/**
*
*  @Auther  gxy
*
*  @Date    2019/11/13
*
*  @Des  音频分类
*
*/
public class NavPresenter extends BasePresenter<INavView> {
    private Context mContext;

    public NavPresenter(Context mContext) {
        this.mContext = mContext;
    }
    //咨询分类
    public void getNavTitle() {
        HttpUtil.getInstance().getApiService().navTitle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<AudioNavBean>() {
                    @Override
                    public void onNextImpl(AudioNavBean entity) {
                        if (AppConstant.CODE_SUCCESS == entity.getStatus()) {
                            getView().onNavSuccess(entity);
                        }else{
                            getView().onNavSuccess(null);
                        }

                    }
                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getNavTitle" + errorMessage);
//                        ToastUtil.showToast("网络开小差了");
                        getView().showTimeout();
                        getView().onNavFalied();
                    }
                });
    }
}
