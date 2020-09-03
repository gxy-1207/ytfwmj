package com.ytfu.lawyercircle.ui.home.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.ContractListSecondBean;

public interface IContractListSecondView extends BaseView {
    void onSecondListSuccess(ContractListSecondBean secondBean);
    void onFiled();
}
