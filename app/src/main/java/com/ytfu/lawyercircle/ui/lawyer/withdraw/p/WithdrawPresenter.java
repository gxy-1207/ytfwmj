package com.ytfu.lawyercircle.ui.lawyer.withdraw.p;

import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.apis.TransactionService;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.lawyer.withdraw.bean.WithdrawResponseBean;
import com.ytfu.lawyercircle.ui.lawyer.withdraw.v.WithdrawView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WithdrawPresenter extends BasePresenter<WithdrawView> {

    /**
     * 律师进行提现操作
     */
    public void withdraw(String uid, String money) {
        HttpUtil.getInstance().getService(TransactionService.class)
                .withdraw(uid, money)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<WithdrawResponseBean>() {

                    @Override
                    public void onSubscribeImpl(Disposable d) {
                        super.onSubscribeImpl(d);
                        getView().showProgress();
                    }

                    @Override
                    public void onNextImpl(WithdrawResponseBean withdrawResponseBean) {
                        getView().hideProgress();
                        if (null == withdrawResponseBean) {
                            getView().onWithdrawFail("请求服务器失败,请稍后重试");
                            return;
                        }
                        int code = withdrawResponseBean.getCode();
                        if (code != 200) {
                            getView().onWithdrawFail(withdrawResponseBean.getMsg());
                            return;
                        }
                        getView().onWithdrawSuccess(withdrawResponseBean);
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        getView().hideProgress();
                    }
                });


    }

}
