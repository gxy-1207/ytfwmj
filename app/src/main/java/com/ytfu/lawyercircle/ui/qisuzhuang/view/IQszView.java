package com.ytfu.lawyercircle.ui.qisuzhuang.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.qisuzhuang.bean.QszFenLeiBean;

public interface IQszView extends BaseView {
    void onQszSuccess(QszFenLeiBean fenLeiBean);
    void onQszFiled();
}
