package com.ytfu.lawyercircle.ui.users.p;

import com.ytfu.lawyercircle.apis.ConsultationApi;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.users.bean.ConsultationDetailsBean;
import com.ytfu.lawyercircle.ui.users.v.ConsultationDetailsView2;

import io.reactivex.Observable;

/**
*
*  @Auther  gxy
*
*  @Date    2020/7/6
*
*  @Des  他的咨询详情p
*
*/
public class ConsultationDetailsRewardPresenter2 extends BasePresenter<ConsultationDetailsView2> {
    //获取咨询详情评价列表
    public void getConsultationDetails2(String id){

        ConsultationApi service = HttpUtil.getInstance().getService(ConsultationApi.class);
        Observable<ConsultationDetailsBean> observable = service.setConsultationDetail(id);
        HttpUtil.getInstance().enqueue(observable, bindLifecycle(), new BaseRxObserver<ConsultationDetailsBean>() {
            @Override
            public void onNextImpl(ConsultationDetailsBean data) {
                int status = data.getStatus();
                if(status == 200){
                    getView().onConsultationDetailsSuccess(data);
                    if(data == null){
                        return;
                    }
                    if("0".equals(data.getContent().getUnlock_type())){
                        return;
                    }
                    if(data.getXiaoxi_arr() == null || data.getXiaoxi_arr().isEmpty()){
                        return;
                    }
//                    getView().stopRefresh();
////                    getView().setNewData(data.getXiaoxi_arr());
////                    getView().loadMoreEnd(true);
                }else{
                    getView().onConsultationDetailsSuccess(data);
                }
            }

            @Override
            public void onErrorImpl(String errorMessage) {
                getView().onConsultationDetailsFiled();
            }
        });
    }
}

