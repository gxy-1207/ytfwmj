package com.ytfu.lawyercircle.ui.lawyer.setting.p;

import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.apis.LawyerService;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.lawyer.setting.v.LawyerSettingView;
import com.ytfu.lawyercircle.ui.mine.bean.InformationBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LawyerSettingPresenter extends BasePresenter<LawyerSettingView> {

    public void getInformation(String uid) {
        HttpUtil.getInstance().getService(LawyerService.class)
                .getInformation(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<InformationBean>() {

                    @Override
                    public void onNextImpl(InformationBean informationBean) {
                        if (null == informationBean) {
                            getView().onGetInformationFail("获取数据失败");
                            return;
                        }
                        int status = informationBean.getStatus();
                        if (status != 1) {
                            getView().onGetInformationFail("获取数据失败");
                            return;
                        }
                        getView().onGetInformationSuccess(informationBean);
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        getView().onGetInformationFail(errorMessage);
                    }
                });

    }

}
