package com.ytfu.lawyercircle.ui.lvshiwenti.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.lvshiwenti.bean.WenTiXiangQingBean;
import com.ytfu.lawyercircle.ui.lvshiwenti.view.IWenTiXqView;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther gxy
 * @Date 2020/5/26
 * @Des 问题详情presenter
 */
public class WenTiXqPresenter extends BasePresenter<IWenTiXqView> {
    private Context mContext;

    public WenTiXqPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void getWenTiXq(HashMap<String,String> map) {
        HttpUtil.getInstance().getApiService().setWenTiXq(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<WenTiXiangQingBean>() {
                    @Override
                    public void onNextImpl(WenTiXiangQingBean wenTiXiangQingBean) {
                        if (wenTiXiangQingBean.getStatus() == 200) {
                            getView().onWenTiXqSuccess(wenTiXiangQingBean);
                        } else {
                            getView().onWenTiXqFiled("错误码"+wenTiXiangQingBean.getStatus()+"错误信息"+wenTiXiangQingBean.getMsg());
                        }
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getWenTiXq" + errorMessage);
                        getView().onWenTiXqFiled(errorMessage);
                    }
                });
    }
}
