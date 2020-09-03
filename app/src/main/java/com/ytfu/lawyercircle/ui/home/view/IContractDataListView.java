package com.ytfu.lawyercircle.ui.home.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.ContractDatalistBean;

public interface IContractDataListView extends BaseView {
    void onDataListSuccess(ContractDatalistBean datalistBean);
    void onFiled();
}
