package com.ytfu.lawyercircle.ui.mine.present;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mine.bean.ModificationBean;
import com.ytfu.lawyercircle.ui.mine.bean.PictureUploadBean;
import com.ytfu.lawyercircle.ui.mine.view.IModificarionView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ModificarionPresenter extends BasePresenter<IModificarionView> {
    private Context mContext;

    public ModificarionPresenter(Context mContext) {
        this.mContext = mContext;
    }

    //头像上传
    public void upLoadImage(RequestBody uid, MultipartBody.Part body) {
        HttpUtil.getInstance().getApiService().getUpLoadImage(uid, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<PictureUploadBean>() {
                    @Override
                    public void onNextImpl(PictureUploadBean entity) {
                        if (AppConstant.CODE_SUCCESS == entity.getStatus()) {
                            getView().onPictureUpLoadSuccess(entity);
                        } else {
                            getView().onPictureUpLoadSuccess(null);
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("upLoadImage" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
//                        getView().showTimeout();
                        getView().onUploadFiled();
                    }
                });
    }

    //修改个人信息
    public void getModifiarion(HashMap<String, String> map) {
        HttpUtil.getInstance().getApiService().getModification(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<ModificationBean>() {
                    @Override
                    public void onNextImpl(ModificationBean entity) {
                        if (AppConstant.CODE_SUCCESS == entity.getStatus()) {
                            getView().onModificartionSuccess(entity);
                        } else {
                            getView().onModificartionSuccess(null);
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getModifiarion" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().onUploadFiled();
                    }
                });
    }
}
