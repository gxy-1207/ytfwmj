package com.ytfu.lawyercircle.ui.lvshihetong.view;

import com.ytfu.lawyercircle.base.BaseRefreshView;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.HomeContractBean;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.VipPageInfo;

public interface LawyerContractView extends BaseRefreshView<HomeContractBean> {

    void onGetVipPageInfo(VipPageInfo data);
}
