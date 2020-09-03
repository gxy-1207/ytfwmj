package com.ytfu.lawyercircle.ui.login.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.login.bean.LoginPwdBean;
import com.ytfu.lawyercircle.ui.login.view.INumPwdView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
*
*  @Auther  gxy
*
*  @Date    2019/11/15
*
*  @Des  账号密码登录present
*
*/
public class NumPwdPresenter extends BasePresenter<INumPwdView> {
    private Context mContext;

    public NumPwdPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void longinNumPwd(HashMap<String,String> map){
        HttpUtil.getInstance().getApiService().goLoginPwd(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<LoginPwdBean>() {
                    @Override
                    public void onNextImpl(LoginPwdBean entity) {
                        getView().onNumPwdSuccess(entity);
                    }
                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getRegistNum" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().onNumPwdFiled();
                    }
                });
    }
}
