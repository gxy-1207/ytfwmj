package com.ytfu.lawyercircle.ui.users.v;

import com.ytfu.lawyercircle.base.BaseRefreshView;
import com.ytfu.lawyercircle.ui.home.bean.HomeBannerBean;
import com.ytfu.lawyercircle.ui.users.bean.LawyerHomeListBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/6/9
*
*  @Des   用户端首页view
*
*/
public interface IUserHomeView extends BaseRefreshView<LawyerHomeListBean.DataBean> {
    //获取轮播图集合
    void userHomeBannerList(HomeBannerBean bannerBean);
    //律师列表
    void userLawyerList(LawyerHomeListBean lawyerHomeListBean);
    void userHomeFiled(String error);
}
