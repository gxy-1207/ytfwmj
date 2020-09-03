package com.ytfu.lawyercircle.ui.knowledge.v

import com.ytfu.lawyercircle.base.BaseView
import com.ytfu.lawyercircle.ui.knowledge.bean.KnowledgeDetailsBean

interface KnowledgeDetailsView :BaseView{
    fun onKnoeledgeSucess( knowledgeDetailsBean: KnowledgeDetailsBean)
    fun onKnoeledgeFlied()
}