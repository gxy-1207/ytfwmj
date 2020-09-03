package com.ytfu.lawyercircle.ui.lvshiwode.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;

import com.github.lee.annotation.InjectLayout;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.base.BaseActivity;
import com.ytfu.lawyercircle.ui.lvshiwode.fragment.ManagementCommonWordsFragment;

import butterknife.BindView;

/**
 * @Auther gxy
 * @Date 2020/7/14
 * @Des 管理常用语
 */
@InjectLayout(value = R.layout.activity_management_common_words, toolbarLayoutId = R.layout.layout_toolbar_center_title)
public class ManagementCommonWordsActivity extends BaseActivity {

    @BindView(R.id.fl_management_common)
    FrameLayout flManagementCommon;


    public static void start(Context context) {
        Intent starter = new Intent(context, ManagementCommonWordsActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void initData() {
        super.initData();
        changeStatusBarTextColor(false);
        setToolbarLeftImage(R.drawable.fanhui_bai, v -> {
            onBackPressed();
        });
        setToolbarText(R.id.tv_global_title, "管理常用语");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_management_common, ManagementCommonWordsFragment.newInstance(""))
                .commitAllowingStateLoss();
    }

}