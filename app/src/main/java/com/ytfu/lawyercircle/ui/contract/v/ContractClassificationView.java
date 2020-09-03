package com.ytfu.lawyercircle.ui.contract.v;

import com.ytfu.lawyercircle.base.BaseRefreshView;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.ContractListSecondBean;

/**
*
*  @Auther  gxy
*
*  @Date    2020/7/30
*
*  @Des 合同分类v
*
*/
public interface ContractClassificationView extends BaseRefreshView<ContractListSecondBean.ListBean> {

    void onContractSuccess(ContractListSecondBean listSecondBean);
    void onContractFiled();
}
