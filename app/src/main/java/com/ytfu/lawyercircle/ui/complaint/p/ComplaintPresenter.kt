package com.ytfu.lawyercircle.ui.complaint.p

import com.ytfu.lawyercircle.R
import com.ytfu.lawyercircle.apis.ComplaintApi
import com.ytfu.lawyercircle.base.BaseRefreshPresenter
import com.ytfu.lawyercircle.helper.BaseRxObserver
import com.ytfu.lawyercircle.ui.complaint.bean.ComplaintResponse
import com.ytfu.lawyercircle.ui.complaint.v.ComplaintView

class ComplaintPresenter : BaseRefreshPresenter<ComplaintView>() {

    /**
     * @param type 是否是用户  true:用户   false：律师*/
    fun getComplaintList(ownerId: String, lawyerId: String? = "", type: Boolean) {

        val ob = createService(ComplaintApi::class.java)
                .complaintList(ownerId, lawyerId ?: "", if (type) 1 else 2)

        requestRemote(ob, object : BaseRxObserver<ComplaintResponse>() {
            override fun onNextImpl(data: ComplaintResponse?) {
                view.stopRefresh()
                if (null == data) {
                    view.setEmptyView(R.layout.layout_empty)
                    view.showToast("获取数据失败，请稍后重试")
                    return
                }
                val status = data.status
                if (status != 200) {
                    view.setEmptyView(R.layout.layout_empty)
                    view.showToast(data.msg)
                    return
                }
                val list = data.list
                if (list.isNullOrEmpty()) {
                    view.setEmptyView(R.layout.layout_empty)
                    return
                }
                view.setNewData(list)

            }

            override fun onErrorImpl(errorMessage: String?) {
                view.setEmptyView(R.layout.layout_empty)
                view.stopRefresh()
            }

            //            override fun onNextImpl(data: QszHistoryBean?) {
            //                if (null == data) {
            //                    view.showToast("获取数据失败，请稍后重试")
            //                    view.setEmptyView(R.layout.layout_empty)
            //                    return
            //                }
            //                if (AppConstant.CODE_SUCCESS != data.status) {
            //                    view.showToast(data.referer)
            //                    view.setEmptyView(R.layout.layout_empty)
            //                    return
            //                }
            //                view.setNewData(data.list)
            //            }
            //
            //            override fun onErrorImpl(errorMessage: String?) {
            //                view.stopRefresh()
            //            }
            //
            //            override fun onCompleteImpl() {
            //                view.stopRefresh()
            //            }
        })

    }
}