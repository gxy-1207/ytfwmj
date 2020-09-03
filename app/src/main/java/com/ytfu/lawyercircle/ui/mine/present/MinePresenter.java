package com.ytfu.lawyercircle.ui.mine.present;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mine.bean.MineBean;
import com.ytfu.lawyercircle.ui.mine.bean.ShenHeJInduBean;
import com.ytfu.lawyercircle.ui.mine.view.IMineView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MinePresenter extends BasePresenter<IMineView> {
//    private Context mContext;

//    public MinePresenter(Context mContext) {
//        this.mContext = mContext;
//    }

    public void setMine(HashMap<String, String> map) {
        HttpUtil.getInstance().getApiService().getMine(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<MineBean>() {
                    @Override
                    public void onNextImpl(MineBean entity) {
                        if (AppConstant.STATUS_SUCCESS == entity.getStatus()) {
                            getView().onMineSuccess(entity);
                        } else {
                            getView().onMineFiled();
                        }

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getNavTitle" + errorMessage);
//                        ToastUtil.showToast("网络开小差了");
                        getView().onMineFiled();
                    }
                });
    }

    public void getShengHeJIndu(HashMap<String, String> map) {
        HttpUtil.getInstance().getApiService().setShengHeJindu(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<ShenHeJInduBean>() {
                    @Override
                    public void onNextImpl(ShenHeJInduBean entity) {
                        getView().onShenHeJinSuccess(entity);
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getShengHeJIndu" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().onMineFiled();
                    }
                });
    }

}
