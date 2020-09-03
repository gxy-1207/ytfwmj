package com.ytfu.lawyercircle.ui.falvguwen.adaper;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.base.adapter.QuickAdapter;
import com.ytfu.lawyercircle.ui.falvguwen.bean.LegalAdviserClassifyBean;
import com.ytfu.lawyercircle.utils.GlideManager;

import org.jetbrains.annotations.NotNull;

public class LegalAdviserAdaper extends QuickAdapter<LegalAdviserClassifyBean.ListBean> {
    public LegalAdviserAdaper() {
        super(R.layout.item_audio_fenlie);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, LegalAdviserClassifyBean.ListBean listBean) {
        super.convert(baseViewHolder, listBean);
        GlideManager.loadImageByUrl(getContext(), listBean.getImg(), baseViewHolder.getView(R.id.iv_zixun));
        baseViewHolder.setText(R.id.tv_fl_title,listBean.getLabel());
        baseViewHolder.setText(R.id.tv_audio_zixun_num,String.format("已有%s人购买",listBean.getCount()));
    }
}