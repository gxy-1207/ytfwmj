package com.ytfu.lawyercircle.ui.lvshiwenti.presenter;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.ApiService;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.lvshiwenti.bean.IWantToAnswerBean;
import com.ytfu.lawyercircle.ui.lvshiwenti.view.IWantToAnswerView;

import io.reactivex.Observable;

/**
 * @Auther gxy
 * @Date 2020/6/18
 * @Des 我要回答presenter
 */
public class IWantToAnswerPresenter extends BasePresenter<IWantToAnswerView> {

    public void getIWantToAnswer(String consultid, String lsid, String content) {
        Observable<IWantToAnswerBean> observable = createService(ApiService.class).setIWantToAnswer(consultid, lsid, content);
        requestRemote(observable, new BaseRxObserver<IWantToAnswerBean>() {
            @Override
            public void onNextImpl(IWantToAnswerBean data) {
                getView().iWantToAnswerSuccess(data);
            }

            @Override
            public void onErrorImpl(String errorMessage) {
                Logger.e("IWantToAnswerPresenter",errorMessage);
            }
        });
    }
}
