package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.PurchaseRecordBean;

public interface IPurchassRecordView extends BaseView {
    void onPurcheRecordSuccess(PurchaseRecordBean recordBean);
    void onFiled();
}
