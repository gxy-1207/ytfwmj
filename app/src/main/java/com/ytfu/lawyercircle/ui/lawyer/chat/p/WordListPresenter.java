package com.ytfu.lawyercircle.ui.lawyer.chat.p;

import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.apis.CommonWordsApi;
import com.ytfu.lawyercircle.base.BaseRefreshPresenter;
import com.ytfu.lawyercircle.base.BaseRefreshView;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.CommonWordsListBean;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class WordListPresenter extends BaseRefreshPresenter<BaseRefreshView<CommonWordsListBean.DataBean>> {
    public void getReplyContent(String userId, String cid) {
        Observable<CommonWordsListBean> cb = createService(CommonWordsApi.class)
                .setCommonWordList(userId, cid);
        requestRemote(cb, new BaseRxObserver<CommonWordsListBean>() {
            @Override
            public void onSubscribeImpl(Disposable d) {
                super.onSubscribeImpl(d);
            }

            @Override
            public void onNextImpl(CommonWordsListBean data) {
                if (data == null) {
                    getView().showToast("未知错误,请稍后重试");
                    return;
                }
                if (data.getCode() != 200) {
                    getView().showToast(data.getMsg());
                    return;
                }

                List<CommonWordsListBean.DataBean> list = data.getData();
                if (null == list || list.isEmpty()) {
                    getView().setEmptyView(R.layout.layout_empty);
                    return;
                }
                getView().setNewData(list);
            }

            @Override
            public void onErrorImpl(String errorMessage) {
                getView().showToast("应用程序出现错误,请稍后重试");
                getView().setEmptyView(R.layout.layout_empty);
                getView().hideProgress();
            }
        });

    }
}
