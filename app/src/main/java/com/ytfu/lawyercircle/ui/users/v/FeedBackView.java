package com.ytfu.lawyercircle.ui.users.v;

import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.users.bean.FeedBackBean;

public interface FeedBackView extends BaseView {
    void onFeekBackSuccess(FeedBackBean feedBackBean);

    void onFeekBackError();
}
