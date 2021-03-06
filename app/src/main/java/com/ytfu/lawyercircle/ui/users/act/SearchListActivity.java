package com.ytfu.lawyercircle.ui.users.act;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.github.lee.annotation.InjectLayout;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.base.BaseActivity;
import com.ytfu.lawyercircle.ui.users.fragment.SearchListFragment;

import qiu.niorgai.StatusBarCompat;

/** @Auther gxy @Date 2020/6/10 @Des 用户端搜索列表Activity */
@InjectLayout(
        value = R.layout.activity_search_list,
        toolbarLayoutId = R.layout.layout_toolbar_center_title)
public class SearchListActivity extends BaseActivity {
    private static final String KEY_LAWYER_NAME = "LAWYER_NAME";
    private static final String KEY_EXPERT_PLACE = "EXPERT_PLACE";

    public static void start(Context context, String lawyername, String expertplace) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_LAWYER_NAME, lawyername);
        bundle.putString(KEY_EXPERT_PLACE, expertplace);
        Intent starter = new Intent(context, SearchListActivity.class);
        starter.putExtras(bundle);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {
        super.initData();
        hideLoading();
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.white));
        changeStatusBarTextColor(true);
        setToolbarBackgroud(getResources().getColor(R.color.white));
        setToolbarLeftImage(R.drawable.fanhui_hui, v -> onBackPressed());
        setToolbarText(R.id.tv_global_title, "搜索");
        setToolbarTextColor(R.id.tv_global_title, getResources().getColor(R.color.textColor_33));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(
                        R.id.fl_search_content,
                        SearchListFragment.newInstance(
                                getBundleString(KEY_LAWYER_NAME, ""),
                                getBundleString(KEY_EXPERT_PLACE, "")))
                .commitAllowingStateLoss();
    }
}
