package com.ytfu.lawyercircle.ui.audio.v

import com.ytfu.lawyercircle.base.BaseView
import com.ytfu.lawyercircle.ui.home.bean.AudioDetailsBean

interface AudioDetailView : BaseView {

    fun onGetAudioDetail(data: AudioDetailsBean)

}

