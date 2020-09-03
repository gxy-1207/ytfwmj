package com.ytfu.lawyercircle.ui.mine.present;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mine.bean.UpdataPwdBean;
import com.ytfu.lawyercircle.ui.mine.view.IUpdataPwdView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther gxy
 * @Date 2020/1/6
 * @Des 修改密码presenter
 */
public class UpDataPwdPresenter extends BasePresenter<IUpdataPwdView> {
    private Context mContext;

    public UpDataPwdPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void setUpdataPwd(HashMap<String,String> map){
        HttpUtil.getInstance().getApiService().getUpDataPwd(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<UpdataPwdBean>() {
                    @Override
                    public void onNextImpl(UpdataPwdBean entity) {
                        if (AppConstant.CODE_SUCCESS == entity.getStatus()) {
                            getView().onUpDataSuccess(entity);
                        } else {
                            getView().onUpDataSuccess(entity);
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setEmail" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().onUpDataFiled();
                    }
                });
    }
}
