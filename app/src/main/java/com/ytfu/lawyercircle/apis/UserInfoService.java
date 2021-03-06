package com.ytfu.lawyercircle.apis;

import com.ytfu.lawyercircle.ui.mine.bean.MineBean;
import com.ytfu.lawyercircle.ui.mine.bean.ShenHeJInduBean;
import com.ytfu.lawyercircle.ui.users.bean.AccountBalanceBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 用户信息相关
 */
public interface UserInfoService {


    @POST("my/get_my_content")
    @FormUrlEncoded
    Observable<MineBean> getUserInfo(@Field("uid") String userId);

    @POST("lvshi/query")
    @FormUrlEncoded
    Observable<ShenHeJInduBean> setAuthInfo(@Field("uid") String userId);


    /**获取账户余额*/
    @POST("my/get_my_pay")
    @FormUrlEncoded
    Observable<AccountBalanceBean> getAccountBalance(@Field("uid") String userId);

}
