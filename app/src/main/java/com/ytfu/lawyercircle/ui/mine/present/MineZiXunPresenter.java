package com.ytfu.lawyercircle.ui.mine.present;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ytfu.lawyercircle.apis.HttpUtil;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.mine.bean.MineZiXunBean;
import com.ytfu.lawyercircle.ui.mine.view.IMineZiXunView;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Auther gxy
 * @Date 2020/5/19
 * @Des 我的咨询presenter
 */
public class MineZiXunPresenter extends BasePresenter<IMineZiXunView> {
    private Context mContext;

    public MineZiXunPresenter(Context mContext) {
        this.mContext = mContext;
    }

    //我的咨询列表
    public void getMineZiXunList(HashMap<String, String> map) {
        HttpUtil.getInstance().getApiService().setMineZiXunList(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(bindLifecycle())
                .subscribe(new BaseRxObserver<MineZiXunBean>() {
                    @Override
                    public void onNextImpl(MineZiXunBean mineZiXunBean) {
                        if (mineZiXunBean.getStatus() == 1) {
                            getView().onMineZiXunSuccess(mineZiXunBean);
                        } else {
                            getView().onMineZiXunSuccess(mineZiXunBean);
                        }
                    }

                    @Override
                    public void onErrorImpl(String errorMessage) {
                        Logger.e("getMineZiXunList" + errorMessage);
                        getView().onMineZiXunFiled();
                    }
                });
    }
}
