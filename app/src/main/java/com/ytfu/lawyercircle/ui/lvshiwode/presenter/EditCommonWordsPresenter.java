package com.ytfu.lawyercircle.ui.lvshiwode.presenter;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.CommonWordsApi;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.EditDeleteCommonWordsBean;
import com.ytfu.lawyercircle.ui.lvshiwode.view.EditCommonWordsView;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * @Auther gxy
 * @Date 2020/7/14
 * @Des 常用语p
 */
public class EditCommonWordsPresenter extends BasePresenter<EditCommonWordsView> {

    public void getEditCommonWords(String ReplyID, String Content) {
        Observable<EditDeleteCommonWordsBean> observable = createService(CommonWordsApi.class).setUpdateCommonWords(ReplyID, Content);
        requestRemote(observable, new BaseRxObserver<EditDeleteCommonWordsBean>() {
            @Override
            public void onSubscribeImpl(Disposable d) {
                super.onSubscribeImpl(d);
                getView().showProgress();
            }

            @Override
            public void onNextImpl(EditDeleteCommonWordsBean data) {
                getView().hideProgress();
                if (data == null) {
                    getView().showToast("应用程序内出现问题，请稍后再试");
                    return;
                }
                if (data.getCode() != 200) {
                    getView().onEditCommonWordsFiled(data.getMsg());
                    return;
                }
                getView().onEditCommonWordsSuccess(data);
            }

            @Override
            public void onErrorImpl(String errorMessage) {
                Logger.e("getEditCommonWords", errorMessage);
            }
        });
    }
} 