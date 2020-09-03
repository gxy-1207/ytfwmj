package com.ytfu.lawyercircle.ui.register.present;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.register.bean.RegistBean;
import com.ytfu.lawyercircle.ui.register.view.IRegistView;
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
*  @Des  注册的present
*
*/
public class RegistPresenter extends BasePresenter<IRegistView> {
    private Context mContext;

    public RegistPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void getRegistNum(HashMap<String,String> map){
        HttpUtil.getInstance().getApiService().goRegist(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<RegistBean>() {
                    @Override
                    public void onNextImpl(RegistBean entity) {
                        getView().onRegistSussess(entity);
                    }
                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getRegistNum" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().onRegistFiled();
                    }
                });
    }
}
