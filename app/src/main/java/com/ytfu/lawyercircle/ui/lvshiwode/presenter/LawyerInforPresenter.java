package com.ytfu.lawyercircle.ui.lvshiwode.presenter;

import android.content.Context;

import com.ytfu.lawyercircle.apis.ApiService;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.LawyerInformationBean;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.LawyerRzUpdateBean;
import com.ytfu.lawyercircle.ui.lvshiwode.view.ILwayerInforView;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * @Auther gxy
 * @Date 2020/5/28
 * @Des 律师认证信息presenter
 */
public class LawyerInforPresenter extends BasePresenter<ILwayerInforView> {
    private Context context;

    public LawyerInforPresenter(Context context) {
        this.context = context;
    }

    //律师认证信息查询
    public void getLawyerInfor(String uid) {
        HttpUtil.getInstance().getService(ApiService.class)
                .setLawyerInfor(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<LawyerInformationBean>() {
                    @Override
                    public void onNextImpl(LawyerInformationBean informationBean) {
                        if (null == informationBean) {
                            getView().onFiled("获取数据失败");
                            return;
                        }
                        int status = informationBean.getStatus();
                        if (status != 1) {
                            getView().onFiled("获取数据失败");
                            return;
                        }
                        if (null == informationBean.getInfo()) {
                            getView().onFiled("解析数据失败");
                            return;
                        }
                        getView().onSelectInforSuccess(informationBean);
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        getView().onFiled(errorMessage);
                    }
                });
    }

    //律师认证修改
    public void getLawyerUpdate(Map<String, RequestBody> map){
        HttpUtil.getInstance().getService(ApiService.class)
                .setLawyerRzUpDate(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<LawyerRzUpdateBean>() {
                    @Override
                    public void onNextImpl(LawyerRzUpdateBean rzUpdateBean) {
                       if(rzUpdateBean.getStatus() == 1){
                           getView().onLawyerInforUpdate(rzUpdateBean);
                       }else{
                           getView().onFiled(rzUpdateBean.getMsg());
                       }
                    }
                    @Override
                    public void onErrorImpl(String errorMessage) {
                        getView().onFiled(errorMessage);
                    }
                });
    }
}
