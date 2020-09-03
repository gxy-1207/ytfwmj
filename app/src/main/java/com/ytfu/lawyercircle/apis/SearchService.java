package com.ytfu.lawyercircle.apis;

import com.ytfu.lawyercircle.ui.search.bean.RecommendWordBean;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface SearchService {

    @POST("find/domainList")
    Observable<RecommendWordBean> getRecommendWords();

}
