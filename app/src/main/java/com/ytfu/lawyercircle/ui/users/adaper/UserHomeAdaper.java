package com.ytfu.lawyercircle.ui.users.adaper;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.base.adapter.QuickAdapter;
import com.ytfu.lawyercircle.ui.users.bean.LawyerHomeListBean;
import com.ytfu.lawyercircle.utils.GlideManager;

import org.jetbrains.annotations.NotNull;

/**
 * @Auther gxy
 * @Date 2020/6/10
 * @Des 用户首页Adaper
 */
public class UserHomeAdaper extends QuickAdapter<LawyerHomeListBean.DataBean> {
    public UserHomeAdaper() {
        super(R.layout.home_mj_recycle_view_item);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, LawyerHomeListBean.DataBean dataBean) {
        super.convert(baseViewHolder, dataBean);
        baseViewHolder.setText(R.id.tv_name, dataBean.getLawyername());
        baseViewHolder.setText(R.id.tv_realm, "擅长领域:" + dataBean.getExpertplace());
        baseViewHolder.setText(R.id.tv_organization, dataBean.getMechanism());
        baseViewHolder.setVisible(R.id.tv_year, !(dataBean.getWorkyear() <= 0));
        baseViewHolder.setText(R.id.tv_year, dataBean.getWorkyear()+"年");
        GlideManager.loadCircleImage(getContext(), dataBean.getIconurl(), baseViewHolder.getView(R.id.iv_header));
    }
}
