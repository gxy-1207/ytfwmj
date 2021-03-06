package com.ytfu.lawyercircle.ui.mine.present;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mine.bean.SetNameBean;
import com.ytfu.lawyercircle.ui.mine.view.ISetNameView;
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
*  @Des  修改昵称presenter
*
*/
public class SetNamePresenter extends BasePresenter<ISetNameView> {
    private Context mContext;

    public SetNamePresenter(Context mContext) {
        this.mContext = mContext;
    }


    public void setName(HashMap<String,String> map){
        HttpUtil.getInstance().getApiService().getSetName(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<SetNameBean>() {
                    @Override
                    public void onNextImpl(SetNameBean entity) {
                        if (AppConstant.CODE_SUCCESS == entity.getStatus()) {
                            getView().onSetNameSuccess(entity);
                        } else {
                            getView().onSetNameSuccess(entity);
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setName" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().onSetNameFiled();
                    }
                });
    }
}
