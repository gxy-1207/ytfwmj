package com.ytfu.lawyercircle.ui.contract.adaper;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.base.adapter.QuickAdapter;
import com.ytfu.lawyercircle.ui.lvshihetong.bean.ContractListSecondBean;

import org.jetbrains.annotations.NotNull;

/**
*
*  @Auther  gxy
*
*  @Date    2020/7/30
*
*  @Des 合同分类adaper
*
*/
public class ContractClassificationAdaper extends QuickAdapter<ContractListSecondBean.ListBean> {

    public ContractClassificationAdaper() {
        super(R.layout.item_contract_recycle_second);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ContractListSecondBean.ListBean listBean) {
        super.convert(baseViewHolder, listBean);
        baseViewHolder.setText(R.id.tv_item,listBean.getLabel());
    }
}