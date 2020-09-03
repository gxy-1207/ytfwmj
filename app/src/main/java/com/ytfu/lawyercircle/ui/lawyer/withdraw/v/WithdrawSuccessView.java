package com.ytfu.lawyercircle.ui.lawyer.withdraw.v;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lawyer.withdraw.bean.WithdrawSuccessBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/7/9
*
*  @Des  体现成功view
*
*/
public interface WithdrawSuccessView extends BaseView {
        void  onWithdrawSuccess(WithdrawSuccessBean withdrawSuccessBean);
        void  onWithdrawFiled();
}
