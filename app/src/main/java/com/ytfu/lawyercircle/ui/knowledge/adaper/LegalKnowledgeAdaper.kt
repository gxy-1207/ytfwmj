package com.ytfu.lawyercircle.ui.knowledge.adaper

import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ytfu.lawyercircle.R
import com.ytfu.lawyercircle.base.adapter.QuickAdapter
import com.ytfu.lawyercircle.ui.knowledge.bean.LegalKnowledgeItemBean

class LegalKnowledgeAdaper: QuickAdapter<LegalKnowledgeItemBean>(R.layout.legalknowledge_item) {
    override fun convert(holder: BaseViewHolder, item: LegalKnowledgeItemBean?) {
        super.convert(holder, item)
        holder.setText(R.id.tv_content,item?.title)
    }
}