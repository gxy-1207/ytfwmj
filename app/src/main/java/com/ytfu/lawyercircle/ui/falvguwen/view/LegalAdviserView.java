package com.ytfu.lawyercircle.ui.falvguwen.view;

import com.ytfu.lawyercircle.base.BaseRefreshView;
import com.ytfu.lawyercircle.ui.falvguwen.bean.LegalAdviserClassifyBean;

public interface LegalAdviserView extends BaseRefreshView<LegalAdviserClassifyBean.ListBean> {
    void onLegalAdSuccess(LegalAdviserClassifyBean classifyBean);
    void onLegalAdFiled();
}
