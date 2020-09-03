package com.ytfu.lawyercircle.ui.lawyer.question.p;

import com.ytfu.lawyercircle.apis.ApiService;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.lawyer.question.bean.AreaResponseBean;
import com.ytfu.lawyercircle.ui.lawyer.question.v.AreaView;

import io.reactivex.Observable;

public class AreaPresenter extends BasePresenter<AreaView> {


    public void getAllArea() {
        Observable<AreaResponseBean> ob = createService(ApiService.class)
                .getAllArea();
        requestRemote(ob, new BaseRxObserver<AreaResponseBean>() {
            @Override
            public void onNextImpl(AreaResponseBean data) {
                getView().onGetAllAreaSuccess(data);
            }

            @Override
            public void onErrorImpl(String errorMessage) {
                getView().onGetAllAreaSuccess(null);
            }
        });

    }
}
