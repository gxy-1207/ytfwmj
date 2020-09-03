package com.ytfu.lawyercircle.ui.consult.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.consult.bean.MIanFeiFaBuBean;
import com.ytfu.lawyercircle.ui.consult.bean.ZiXunNavBean;
import com.ytfu.lawyercircle.ui.consult.view.IZiXunNavView;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ZiXunNavPresenter extends BasePresenter<IZiXunNavView> {
    private Context mContext;

    public ZiXunNavPresenter(Context mContext) {
        this.mContext = mContext;
    }

    //咨询类型分类
    public void setZiXunNav() {
        HttpUtil.getInstance().getApiService().getZiXunNav()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<ZiXunNavBean>() {
                    @Override
                    public void onNextImpl(ZiXunNavBean entity) {
                        if (AppConstant.CODE_SUCCESS == entity.getStatus()) {
                            getView().onZiXunNavSuccess(entity);
                        } else {
                            getView().onZiXunNavSuccess(null);
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getNavTitle" + errorMessage);
//                        ToastUtil.showToast("网络开小差了");
                        getView().showTimeout();
                        getView().onZiXunNavFiled();
                    }
                });
    }

    //免费发布咨询
    public void getMianFeiFabu(HashMap<String, String> map) {
        HttpUtil.getInstance().getApiService().setMianFeiFaBu(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<MIanFeiFaBuBean>() {
                    @Override
                    public void onNextImpl(MIanFeiFaBuBean entity) {
                        if (AppConstant.STATUS_SUCCESS == entity.getStatus()) {
                            getView().onMianFeiFaBuSuccess(entity);
                        } else {
                            getView().onMianFeiFaBuSuccess(null);
                        }
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getNavTitle" + errorMessage);
//                        ToastUtil.showToast("网络开小差了");
//                        getView().showTimeout();
                        getView().onZiXunNavFiled();
                    }
                });
    }
}
