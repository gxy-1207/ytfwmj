package com.ytfu.lawyercircle.apis;

import com.ytfu.lawyercircle.ui.mine.bean.ResumeResponseBean;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * 简历相关
 */
public interface ResumeService {

    @POST("lvshi/get_jianjie")
    Observable<ResumeResponseBean> getResumeTemplate();


}
