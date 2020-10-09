package com.ytfu.lawyercircle.ui.users.p;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.ApiService;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.users.bean.FeedBackBean;
import com.ytfu.lawyercircle.ui.users.v.FeedBackView;

import io.reactivex.Observable;

public class FeedBackPresenter extends BasePresenter<FeedBackView> {
    public void setFeedBack(String uid, String content, String mobile, String name, int type) {
        Observable<FeedBackBean> observable =
                createService(ApiService.class).getFeedBack(uid, content, mobile, name, type);
        requestRemote(
                observable,
                new BaseRxObserver<FeedBackBean>() {
                    @Override
                    public void onNextImpl(FeedBackBean data) {
                        if (data.getStatus() != 1) {
                            getView().showToast("投诉失败");
                            return;
                        }
                        getView().onFeekBackSuccess(data);
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("setFeedBack------" + errorMessage);
                        getView().showToast("投诉失败");
                    }
                });
    }
}
