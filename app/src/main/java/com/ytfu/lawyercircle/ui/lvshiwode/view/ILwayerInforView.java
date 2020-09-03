package com.ytfu.lawyercircle.ui.lvshiwode.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.LawyerInformationBean;
import com.ytfu.lawyercircle.ui.lvshiwode.bean.LawyerRzUpdateBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/5/28
*
*  @Des  律师认证信息view
*
*/
public interface ILwayerInforView extends BaseView {
    //查询
    void onSelectInforSuccess(LawyerInformationBean informationBean);
    //律师认证修改
    void onLawyerInforUpdate(LawyerRzUpdateBean rzUpdateBean);
    void onFiled(String error);
}
