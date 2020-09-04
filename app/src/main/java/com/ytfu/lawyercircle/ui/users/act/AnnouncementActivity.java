package com.ytfu.lawyercircle.ui.users.act;

import android.content.Context;
import android.content.Intent;

import com.github.lee.annotation.InjectLayout;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.base.BaseActivity;
import com.ytfu.lawyercircle.ui.users.fragment.AnnouncementFragment;

import qiu.niorgai.StatusBarCompat;

/** @Auther gxy @Date 2020/6/10 @Des 公告页面 */
@InjectLayout(
        value = R.layout.activity_announcement,
        toolbarLayoutId = R.layout.layout_toolbar_center_title)
public class AnnouncementActivity extends BaseActivity {
    public static void start(Context context) {
        Intent starter = new Intent(context, AnnouncementActivity.class);
        //        starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void initData() {
        super.initData();
        hideLoading();
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.white));
        changeStatusBarTextColor(false);
        setToolbarBackgroud(getResources().getColor(R.color.white));
        setToolbarLeftImage(
                R.drawable.fanhui_hui,
                v -> {
                    onBackPressed();
                });
        setToolbarTextColor(R.id.tv_global_title, getResources().getColor(R.color.textColor_33));
        setToolbarText(R.id.tv_global_title, "公告");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_announcenment_coun, AnnouncementFragment.newInstance())
                .commitAllowingStateLoss();
    }
}
