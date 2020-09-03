package com.ytfu.lawyercircle.ui.knowledge.p

import com.orhanobut.logger.Logger
import com.ytfu.lawyercircle.apis.LegalKnoeledgeService
import com.ytfu.lawyercircle.base.BasePresenter
import com.ytfu.lawyercircle.helper.BaseRxObserver
import com.ytfu.lawyercircle.ui.knowledge.bean.KnowledgeDetailsBean
import com.ytfu.lawyercircle.ui.knowledge.v.KnowledgeDetailsView


class KnowledgeDetailsPresenter : BasePresenter<KnowledgeDetailsView>() {
    fun setKnowledgeDetails(id: String) {
        val ob = createService(LegalKnoeledgeService::class.java).getKnowledgeDetails(id)
        requestRemote(ob, object : BaseRxObserver<KnowledgeDetailsBean>() {
            override fun onNextImpl(data: KnowledgeDetailsBean?) {
                if (data == null) {
                    view.showEmpty()
                    return
                }
                if (data.status != 200) {
                    view.showEmpty()
                    return
                }
                view.onKnoeledgeSucess(data)
            }

            override fun onErrorImpl(errorMessage: String?) {
                view.showEmpty()
                Logger.e("setKnowledgeDetails", errorMessage)
            }

        })
    }
}