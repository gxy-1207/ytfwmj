package com.ytfu.lawyercircle.ui.register.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.register.bean.RegistBean;

public interface IRegistView extends BaseView {
    void onRegistSussess(RegistBean registBean);
    void onRegistFiled();
}
