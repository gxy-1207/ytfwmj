package com.ytfu.lawyercircle.ui.search.p;

import com.ytfu.lawyercircle.apis.SearchService;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.helper.BaseRxObserver;
import com.ytfu.lawyercircle.ui.search.bean.HistoryWord;
import com.ytfu.lawyercircle.ui.search.bean.RecommendWordBean;
import com.ytfu.lawyercircle.ui.search.v.SearchView;

import org.litepal.LitePal;

import java.util.List;

import io.reactivex.Observable;

public class SearchPresenter extends BasePresenter<SearchView> {

    /**
     * 请求服务器获取推荐搜索词
     */
    public void getRecommendWords() {
        Observable<RecommendWordBean> ob = createService(SearchService.class)
                .getRecommendWords();
        requestRemote(ob, new BaseRxObserver<RecommendWordBean>() {

            @Override
            public void onNextImpl(RecommendWordBean data) {
                if (null == data) {
                    getView().onRecommendWordsFail();
                    return;
                }
                int code = data.getCode();
                if (code != 200) {
                    getView().onRecommendWordsFail();
                    return;
                }
                List<RecommendWordBean.DataBean> list = data.getData();
                if (null == list || list.isEmpty()) {
                    getView().onRecommendWordsFail();
                    return;
                }
                getView().onRecommendWordsSuccess(list);

            }

            @Override
            public void onErrorImpl(String errorMessage) {
                getView().onRecommendWordsFail();
            }
        });

    }

    /**
     * 获取历史搜索记录
     */
    public void getSearchHistory() {
        List<HistoryWord> all = LitePal.order("time desc").find(HistoryWord.class);
        getView().onSearchHistorySuccess(all);
    }
}
