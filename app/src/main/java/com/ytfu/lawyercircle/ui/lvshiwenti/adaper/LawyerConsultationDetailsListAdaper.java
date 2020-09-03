package com.ytfu.lawyercircle.ui.lvshiwenti.adaper;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.base.adapter.QuickAdapter;
import com.ytfu.lawyercircle.ui.users.bean.ConsultationDetailsBean;
import com.ytfu.lawyercircle.utils.GlideManager;

import org.jetbrains.annotations.NotNull;

/**
*
*  @Auther  gxy
*
*  @Date    2020/6/15
*
*  @Des 律师详情列表adaper
*
*/
public class LawyerConsultationDetailsListAdaper extends QuickAdapter<ConsultationDetailsBean.XiaoxiArrBean> {
    public LawyerConsultationDetailsListAdaper() {
        super(R.layout.consultation_details_recycleview_item);
//        addChildClickViewIds(R.id.tv_communicate_now);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ConsultationDetailsBean.XiaoxiArrBean xiaoxiArrBean) {
        super.convert(baseViewHolder, xiaoxiArrBean);
        GlideManager.loadImageByUrl(getContext(),xiaoxiArrBean.getAvatar(),baseViewHolder.getView(R.id.iv_header));
        baseViewHolder.setText(R.id.tv_name,xiaoxiArrBean.getUser_login());
        baseViewHolder.setText(R.id.tv_time,xiaoxiArrBean.getCon_date());
        baseViewHolder.setText(R.id.tv_connect,xiaoxiArrBean.getContent());
        baseViewHolder.setGone(R.id.tv_communicate_now,true);
    }
}
