package com.ytfu.lawyercircle.ui.mine.present;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mine.bean.LvShiRenZhengCommitBean;
import com.ytfu.lawyercircle.ui.mine.view.ILvShiRenZhengCommitView;
import com.ytfu.lawyercircle.utils.ToastUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * @Auther gxy
 * @Date 2020/5/22
 * @Des 律师认证presenter
 */
public class LvShiRenZhengCommitPresenter extends BasePresenter<ILvShiRenZhengCommitView> {
    private Context mContext;

    public LvShiRenZhengCommitPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void getLvShiRenZhengCommit(HashMap<String, RequestBody> map) {
        HttpUtil.getInstance().getApiService().setLvShiRenZhengCommit(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<LvShiRenZhengCommitBean>() {
                    @Override
                    public void onNextImpl(LvShiRenZhengCommitBean entity) {

                        getView().onLvShiCommitSuccess(entity);

                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getNavTitle" + errorMessage);
                        ToastUtil.showToast("网络开小差了");
                        getView().onLvShiCommitFiled();
                    }
                });
    }
}
