package com.ytfu.lawyercircle.ui.qisuzhuang.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.BdEmailBean;
import com.ytfu.lawyercircle.ui.qisuzhuang.bean.ZjqdXqBean;
import com.ytfu.lawyercircle.ui.qisuzhuang.bean.ZjqdXqSendEmailBean;

/**
*
*  @Auther  gxy
*
*  @Date    2019/12/18
*
*  @Des  证据清单详情view
*
*/
public interface IZjqdXqView extends BaseView {
    void onZjqdXqSuccess(ZjqdXqBean zjqdXqBean);
    void onZjqdXqFiled();
    void onZjqdXqSendSuccess(ZjqdXqSendEmailBean sendEmailBean);
    void onBdEmailSuccess(BdEmailBean bdEmailBean);
}
