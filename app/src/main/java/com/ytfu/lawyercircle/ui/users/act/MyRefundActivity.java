package com.ytfu.lawyercircle.ui.users.act;

import android.content.Context;
import android.content.Intent;

import com.github.lee.annotation.InjectLayout;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.base.BaseActivity;
import com.ytfu.lawyercircle.ui.users.fragment.MyRefundFragment;

import qiu.niorgai.StatusBarCompat;

/** @Auther gxy @Date 2020/7/23 @Des 我的退款 */
@InjectLayout(
        value = R.layout.activity_my_refund,
        toolbarLayoutId = R.layout.layout_toolbar_center_title)
public class MyRefundActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MyRefundActivity.class);
        //        starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void initData() {
        super.initData();
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.white));
        changeStatusBarTextColor(true);
        setToolbarBackgroud(getResources().getColor(R.color.white));
        setToolbarLeftImage(R.drawable.fanhui_hui, view -> onBackPressed());
        setToolbarText(R.id.tv_global_title, "退款明细");
        setToolbarTextColor(R.id.tv_global_title, getResources().getColor(R.color.textColor_33));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_refund_connect, MyRefundFragment.newInstance())
                .commitAllowingStateLoss();
    }
}
