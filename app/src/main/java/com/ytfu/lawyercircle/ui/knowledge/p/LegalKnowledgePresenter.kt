package com.ytfu.lawyercircle.ui.knowledge.p

import com.ytfu.lawyercircle.R
import com.ytfu.lawyercircle.apis.LegalKnoeledgeService
import com.ytfu.lawyercircle.base.BaseRefreshPresenter
import com.ytfu.lawyercircle.base.BaseRefreshView
import com.ytfu.lawyercircle.helper.BaseRxObserver
import com.ytfu.lawyercircle.ui.knowledge.bean.LegalKnowledgeBean
import com.ytfu.lawyercircle.ui.knowledge.bean.LegalKnowledgeItemBean

class LegalKnowledgePresenter : BaseRefreshPresenter<BaseRefreshView<LegalKnowledgeItemBean>>() {
    fun setLegalKmowedge() {
        val ob = createService(LegalKnoeledgeService::class.java).getLegalKnoeledge()
        requestRemote(ob, object : BaseRxObserver<LegalKnowledgeBean>() {
            override fun onCompleteImpl() {
                super.onCompleteImpl()
                view.stopRefresh()
            }

            override fun onNextImpl(data: LegalKnowledgeBean?) {
                if (data == null) {
                    view.setEmptyView(R.layout.layout_empty)
                    return
                }
                if (data.status != 200) {
                    view.setEmptyView(R.layout.layout_empty)
                    return
                }
                if (data.list.isEmpty()) {
                    view.setEmptyView(R.layout.layout_empty)
                    return
                }
                view.setNewData(data.list)
            }

            override fun onErrorImpl(errorMessage: String?) {
                view.setEmptyView(R.layout.layout_empty)
                view.stopRefresh()
            }

        })
    }
}