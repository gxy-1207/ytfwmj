package com.ytfu.lawyercircle.ui.audio.v;


import com.ytfu.lawyercircle.base.BaseView;
import com.ytfu.lawyercircle.ui.home.bean.AudioNavBean;

import java.util.List;

public interface AudioClassificationView extends BaseView {

    void onGetAudioClassify(List<AudioNavBean.ListBean> list);

}
