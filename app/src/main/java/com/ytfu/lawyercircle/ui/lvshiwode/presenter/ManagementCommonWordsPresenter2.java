package com.ytfu.lawyercircle.ui.lvshiwode.presenter;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.CommonWordsApi;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.ClassificationOfCommonWordsBean;
import com.ytfu.lawyercircle.ui.lvshiwode.view.ManagementCommonWordsView2;

import io.reactivex.Observable;

/**
 * @Auther gxy
 * @Date 2020/7/15
 * @Des 管理常用语p
 */
public class ManagementCommonWordsPresenter2 extends BasePresenter<ManagementCommonWordsView2> {
    public void getClassificationOfCommonWords(){
        Observable<ClassificationOfCommonWordsBean> observable = createService(CommonWordsApi.class).setClassificationOfCommonWords();
        requestRemote(observable, new BaseRxObserver<ClassificationOfCommonWordsBean>() {
            @Override
            public void onNextImpl(ClassificationOfCommonWordsBean data) {
                if(data == null){
                    return;
                }
                if(data.getStatus() !=1){
                    return;
                }
                if(data.getList() == null || data.getList().isEmpty()){
                    return;
                }
                getView().onCategorySuccess(data);
            }

            @Override
            public void onErrorImpl(String errorMessage) {
                Logger.e("getClassificationOfCommonWords",errorMessage);
            }
        });
    }
} 