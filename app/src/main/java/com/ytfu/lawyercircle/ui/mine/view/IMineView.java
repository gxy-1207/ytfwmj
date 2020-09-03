package com.ytfu.lawyercircle.ui.mine.view;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.mine.bean.MineBean;
import com.ytfu.lawyercircle.ui.mine.bean.ShenHeJInduBean;

public interface IMineView extends BaseView {
    void onMineSuccess(MineBean mineBean);
    void onShenHeJinSuccess(ShenHeJInduBean shenHeJInduBean);
    void onMineFiled();
}
