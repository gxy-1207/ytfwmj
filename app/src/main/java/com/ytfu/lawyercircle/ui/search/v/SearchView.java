package com.ytfu.lawyercircle.ui.search.v;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.search.bean.HistoryWord;
import com.ytfu.lawyercircle.ui.search.bean.RecommendWordBean;

import java.util.List;

public interface SearchView extends BaseView {

    void onRecommendWordsSuccess(List<RecommendWordBean.DataBean> data);

    void onRecommendWordsFail();

    void onSearchHistorySuccess(List<HistoryWord> data);
}
