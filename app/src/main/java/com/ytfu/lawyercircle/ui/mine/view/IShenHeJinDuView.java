package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.ShenHeJInduBean;

/**
 * @Auther gxy
 * @Date 2020/5/21
 * @Des 审核进度view
 */
public interface IShenHeJinDuView extends BaseView {
    void onShenHeJinSuccess(ShenHeJInduBean shenHeJInduBean);

    void onShengheJinduFiled();
}
