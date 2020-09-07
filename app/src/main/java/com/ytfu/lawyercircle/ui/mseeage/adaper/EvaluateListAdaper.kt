package com.ytfu.lawyercircle.ui.mseeage.adaper

import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ytfu.lawyercircle.R
import com.ytfu.lawyercircle.base.adapter.QuickAdapter
import com.ytfu.lawyercircle.ui.mseeage.bean.Shuju

/**
 * @ClassName:      EvaluateListAdaper
 * @Author:         gxy
 * @CreateDate:     2020/8/26
 * @Description:     评价列表Adaper
 */
class EvaluateListAdaper : QuickAdapter<Shuju>(R.layout.item_user_evaluate) {

    override fun convert(holder: BaseViewHolder, item: Shuju?) {
        super.convert(holder, item)
        holder.setText(R.id.tv_huida_name, item?.nickname)
        holder.setText(R.id.tv_huida_time, item?.yhaddtime)
        holder.setText(R.id.tv_content, item?.name)
        holder.setText(R.id.tv_leixing, item?.cid)
        holder.setText(R.id.tv_num, item?.count)
        holder.setBackgroundResource(R.id.iv_ta_icon, R.mipmap.mj_icon_app_logo)
    }
}