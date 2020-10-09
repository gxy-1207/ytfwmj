package com.ytfu.lawyercircle.ui.updatapk

import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName


@Keep
data class StatusBean(
        @SerializedName("caina")
        var caina: String,
        @SerializedName("jiaji")
        var jiaji: String,
        @SerializedName("jiesuo")
        var jiesuo: String,
        @SerializedName("jiesuo_descript")
        var jiesuoDescript: String,
        @SerializedName("jiesuo_title")
        var jiesuoTitle: String,
        @SerializedName("new_zixun_xiangqing")
        var newZixunXiangqing: String,
        @SerializedName("referer")
        var referer: String,
        @SerializedName("state")
        var state: String,
        @SerializedName("status")
        var status: Int,
        @SerializedName("top")
        var top: String,
        @SerializedName("tuikuan")
        var tuikuan: Int,
        @SerializedName("user_kefu_phone")
        var userKefuPhone: String,
        @SerializedName("user_kefu_status")
        var userKefuStatus: Int,
        @SerializedName("user_tousu_status")
        var userTousuStatus: Int,
        @SerializedName("xiaoxi_tousu_status")
        var xiaoxiTousuStatus: Int,
        @SerializedName("xuanshang_descript")
        var xuanshangDescript: String,
        @SerializedName("zhuijia_descript")
        var zhuijiaDescript: String,
        @SerializedName("zhuijia_title")
        var zhuijiaTitle: String,
        @SerializedName("zixun_descript")
        var zixunDescript: String
)