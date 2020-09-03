package com.ytfu.lawyercircle.ui.qisuzhuang.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.qisuzhuang.bean.QszXqFlBean;

/**
*
*  @Auther  gxy
*
*  @Date    2019/12/17
*
*  @Des  起诉状详情分类view
*
*/
public interface IQszXqFlView extends BaseView {
    void onSuccess(QszXqFlBean xqFlBean);
    void onFiled();
}
