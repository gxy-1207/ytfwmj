package com.ytfu.lawyercircle.ui.lvshihetong.presenter;

import com.ytfu.lawyercircle.apis.ApiService;
import com.ytfu.lawyercircle.base.BaseRefreshPresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.VipPageInfo;
import com.ytfu.lawyercircle.ui.lvshihetong.view.LawyerContractView;

import io.reactivex.Observable;

public class LawyerContractPresenter extends BaseRefreshPresenter<LawyerContractView> {

    public void getVipPageInfo() {
        Observable<VipPageInfo> ob = createService(ApiService.class).getVipPageInfo();

        requestRemote(
                ob,
                new BaseRxObserver<VipPageInfo>() {
                    @Override
                    public void onNextImpl(VipPageInfo data) {
                        if (null == data) {
                            getView().showError();
                            return;
                        }
                        int status = data.getStatus();
                        if (status != 1) {
                            getView().showError();
                            return;
                        }
                        getView().onGetVipPageInfo(data);
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        getView().showError();
                        getView().stopRefresh();
                    }

                    @Override
                    public void onCompleteImpl() {
                        super.onCompleteImpl();
                        getView().stopRefresh();
                    }
                });
    }
}
