package com.ytfu.lawyercircle.ui.mseeage.activity;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.lee.annotation.InjectLayout;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.base.BaseActivity;
import com.ytfu.lawyercircle.ui.custom.MyRadioGroup;
import com.ytfu.lawyercircle.ui.mseeage.adaper.SuccessAnLiAdaper;
import com.ytfu.lawyercircle.ui.mseeage.bean.SuccessAnLiBean;
import com.ytfu.lawyercircle.ui.mseeage.presenter.SuccessAnLiPresenter;
import com.ytfu.lawyercircle.ui.mseeage.view.ISuccessAnLiView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;

@InjectLayout(
        value = R.layout.activity_success_anli,
        toolbarLayoutId = R.layout.layout_toolbar_center_title)
public class SuccessAnLiActivity extends BaseActivity<ISuccessAnLiView, SuccessAnLiPresenter>
        implements ISuccessAnLiView {
    @BindView(R.id.iv_fanhui)
    ImageView ivFanhui;

    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;

    @BindView(R.id.flowlayout)
    MyRadioGroup flowlayout;

    @BindView(R.id.rl_content)
    RecyclerView rlContent;

    @BindView(R.id.ll_empey)
    LinearLayout llEmpty;

    private ViewGroup.MarginLayoutParams layoutParams;
    private String lid;
    private SuccessAnLiAdaper successAnLiAdaper;
    Bitmap a = null;

    //    @Override
    //    protected int provideContentViewId() {
    //        return R.layout.activity_success_anli;
    //    }

    @Override
    protected View provideLoadServiceRootView() {
        return rlContent;
    }

    @Override
    protected SuccessAnLiPresenter createPresenter() {
        return new SuccessAnLiPresenter(this);
    }

    @Override
    public void init() {
        super.init();
        //        Eyes.setStatusBarColor(this, CommonUtil.getColor(R.color.transparent_4c));
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.white));
        changeStatusBarTextColor(true);
    }

    @Override
    protected void initView() {
        //        hideLoading();
        setToolbarBackgroud(getResources().getColor(R.color.white));
        setToolbarLeftImage(R.drawable.fanhui_hui, view -> onBackPressed());
        setToolbarTextColor(R.id.tv_global_title, getResources().getColor(R.color.textColor_33));
        setToolbarText(R.id.tv_global_title, "成功案例");
        tvTopTitle.setText("成功案例");
        lid = getIntent().getStringExtra("lid");
        layoutParams =
                new RadioGroup.LayoutParams(
                        RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin = 20;
        layoutParams.rightMargin = 20;
        layoutParams.topMargin = 15;
        layoutParams.bottomMargin = 10;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlContent.setLayoutManager(layoutManager);
        successAnLiAdaper = new SuccessAnLiAdaper(this);
        rlContent.setAdapter(successAnLiAdaper);
    }

    @Override
    protected void initData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("lid", lid);
        getPresenter().getSuccessAnli(map);
    }

    @OnClick(R.id.iv_fanhui)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onAnliSuccess(SuccessAnLiBean successAnLiBean) {
        hideLoading();
        if (successAnLiBean != null && successAnLiBean.getCategory() != null) {
            List<SuccessAnLiBean.CategoryBean> category = successAnLiBean.getCategory();
            if (flowlayout.getChildCount() == 0) {
                for (int i = 0; i < category.size(); i++) {
                    //                    view = new TextView(this);
                    RadioButton button = new RadioButton(this);
                    button.setText(category.get(i).getName());
                    button.setButtonDrawable(new BitmapDrawable(a));
                    button.setBackgroundResource(R.drawable.textview_color_selector);
                    ColorStateList csl =
                            getResources().getColorStateList(R.color.selector_radio_check);
                    button.setTextColor(csl);

                    int finalI = i;
                    button.setOnCheckedChangeListener(
                            new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(
                                        CompoundButton buttonView, boolean isChecked) {
                                    if (isChecked) {
                                        showWaitingDialog("加载中...", true);
                                        int id = category.get(finalI).getId();
                                        HashMap<String, String> map = new HashMap<>();
                                        map.put("lid", lid);
                                        map.put("cid", String.valueOf(id));
                                        getPresenter().getSuccessAnli(map);
                                    }
                                }
                            });
                    flowlayout.addView(button, layoutParams);
                }
                //                RadioButton radio = (RadioButton) flowlayout.getChildAt(0);
                //                radio.setChecked(true);
            }
        }
        if (successAnLiBean.getShuju().size() != 0) {
            llEmpty.setVisibility(View.GONE);
            rlContent.setVisibility(View.VISIBLE);
            hideWaitingDialog();
            successAnLiAdaper.setShujuBeanList(successAnLiBean.getShuju());
        } else {
            hideWaitingDialog();
            successAnLiAdaper.clean();
            //            showEmpty();
            llEmpty.setVisibility(View.VISIBLE);
            rlContent.setVisibility(View.GONE);
        }
    }

    @Override
    public void onAnLiFiled() {}
}
