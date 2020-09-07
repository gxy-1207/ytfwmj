package com.ytfu.lawyercircle.ui.lvshiwode.activity;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.lee.annotation.InjectLayout;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.base.BaseActivity;
import com.ytfu.lawyercircle.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;

/** @Auther gxy @Date 2020/5/27 @Des 律师须知页面 */
@InjectLayout(
        value = R.layout.activity_lawyer_notice,
        toolbarLayoutId = R.layout.layout_toolbar_center_title)
public class LawyerNoticeActivity extends BaseActivity {
    @BindView(R.id.web_view)
    WebView webView;

    @BindView(R.id.iv_fanhui)
    ImageView ivFanhui;

    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;

    private String url = "http://yuntaifawu.com/portal/index/lvshixuzhi";

    //    @Override
    //    protected int provideContentViewId() {
    //        return R.layout.activity_lawyer_notice;
    //    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, LawyerNoticeActivity.class);
        context.startActivity(intent);
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
        hideLoading();
        tvTopTitle.setText("律师须知");
        setToolbarBackgroud(getResources().getColor(R.color.white));
        setToolbarText(R.id.tv_global_title, "律师须知");
        setToolbarLeftImage(R.drawable.fanhui_hui, view -> onBackPressed());
        setToolbarTextColor(R.id.tv_global_title, getResources().getColor(R.color.textColor_33));
        webView.setHorizontalScrollBarEnabled(false); // 水平不显示
        webView.setVerticalScrollBarEnabled(false); // 垂直不显示
        webView.loadUrl(url);
    }

    @Override
    protected void initData() {}

    @OnClick(R.id.iv_fanhui)
    public void onViewClicked() {
        finish();
    }
}
