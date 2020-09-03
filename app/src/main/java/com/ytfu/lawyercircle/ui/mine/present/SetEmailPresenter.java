package com.ytfu.lawyercircle.ui.mine.present;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mine.bean.SetEmailBean;
import com.ytfu.lawyercircle.ui.mine.view.ISetEmailView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
*
*  @Auther  gxy
*
*  @Date    2020/1/6
*
*  @Des  修改邮箱presenter
*
*/
public class SetEmailPresenter extends BasePresenter<ISetEmailView> {
    private Context mContext;

    public SetEmailPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void setEmail(HashMap<String,String> map){
        HttpUtil.getInstance().getApiService().getEmail(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<SetEmailBean>() {
                    @Override
                    public void onNextImpl(SetEmailBean entity) {
                        if (AppConstant.CODE_SUCCESS == entity.getStatus()) {
                            getView().onSetEmailSuccess(entity);
                        } else {
                            getView().onSetEmailSuccess(entity);
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setEmail" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().onSetEmailFiled();
                    }
                });
    }
}
