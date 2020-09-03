package com.ytfu.lawyercircle.ui.falvguwen.presenter;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.apis.ApiService;
import com.ytfu.lawyercircle.base.BaseRefreshPresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.falvguwen.bean.LegalAdviserClassifyBean;
import com.ytfu.lawyercircle.ui.falvguwen.view.LegalAdviserView;

import io.reactivex.Observable;

public class LegalAdviserPresenter extends BaseRefreshPresenter<LegalAdviserView> {
   public void setLegalAdviser(){
       Observable<LegalAdviserClassifyBean> observable = createService(ApiService.class).getFLGW();
       requestRemote(observable, new BaseRxObserver<LegalAdviserClassifyBean>() {
           @Override
           public void onCompleteImpl() {
               super.onCompleteImpl();
               getView().stopRefresh();
           }

           @Override
           public void onNextImpl(LegalAdviserClassifyBean data) {
               if(data == null){
                   getView().setEmptyView(R.layout.layout_empty);
                   return;
               }
               if(data.getStatus() != 200){
                   getView().setEmptyView(R.layout.layout_empty);
                   return;
               }
               if(data.getList() == null || data.getList().isEmpty()){
                   getView().setEmptyView(R.layout.layout_empty);
                   return;
               }
               getView().setNewData(data.getList());
               getView().onLegalAdSuccess(data);
           }

           @Override
           public void onErrorImpl(String errorMessage) {
               getView().setEmptyView(R.layout.layout_empty);
               getView().stopRefresh();
               Logger.e("setLegalAdviser",errorMessage);
           }
       });
   }
}