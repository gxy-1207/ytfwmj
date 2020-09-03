package com.ytfu.lawyercircle.ui.audio.p;

import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.apis.ApiService;
import com.ytfu.lawyercircle.base.BaseRefreshPresenter;
import com.ytfu.lawyercircle.base.BaseRefreshView;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.home.bean.AudioListBean;

import java.util.List;

import io.reactivex.Observable;

public class AudioSearchListPresenter extends BaseRefreshPresenter<BaseRefreshView<AudioListBean.ListBean>> {


    public void getAudioSearchList(boolean isLoadMore, int page, String keyword) {
        Observable<AudioListBean> ob = createService(ApiService.class)
                .navAudioSearchList(page, keyword);
        requestRemote(ob, new BaseRxObserver<AudioListBean>() {
            @Override
            public void onNextImpl(AudioListBean data) {
                if (null == data) {
                    if (isLoadMore) {
                        getView().loadMoreComplete();
                    } else {
                        getView().setEmptyView(R.layout.layout_empty);
                        getView().stopRefresh();
                    }
                    getView().resetCurrentPage(isLoadMore, 1);
                    return;
                }
                int status = data.getStatus();
                if (status != 1) {
                    if (isLoadMore) {
                        getView().loadMoreEnd(false);
                    } else {
                        getView().setEmptyView(R.layout.layout_empty);
                        getView().stopRefresh();
                    }
                    getView().resetCurrentPage(isLoadMore, 1);
                    return;
                }
                List<AudioListBean.ListBean> list = data.getList();
                if (null == list || list.isEmpty()) {
                    if (isLoadMore) {
                        getView().loadMoreEnd(false);
                    } else {
                        getView().setEmptyView(R.layout.layout_empty);
                        getView().stopRefresh();
                    }
                    getView().resetCurrentPage(isLoadMore, 1);
                    return;
                }
                if (isLoadMore) {
                    getView().loadMoreComplete();
                    getView().addData(list);
                } else {
                    getView().setNewData(list);
                    getView().stopRefresh();
                }
            }

            @Override
            public void onErrorImpl(String errorMessage) {
                if (isLoadMore) {
                    getView().loadMoreComplete();
                } else {
                    getView().setEmptyView(R.layout.layout_empty);
                    getView().stopRefresh();
                }
                getView().resetCurrentPage(isLoadMore, 1);
            }
        });
    }
}
