package com.ytfu.lawyercircle.ui.mine.activity;

import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BaseActivity;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.utils.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Auther gxy
 * @Date 2020/5/20
 * @Des 律师认证设置姓名
 */
public class ActivityLvShiRenZhengSetName extends BaseActivity {
    @BindView(R.id.iv_fanhui)
    ImageView ivFanhui;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.tv_qd)
    TextView tvQd;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.iv_clear)
    ImageView ivClear;

    @Override
    public void init() {
        super.init();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
//      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.transparent_f2));

        }
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_lvshi_renzhneg_setname;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        hideLoading();
        tvTopTitle.setText("姓名");
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.iv_fanhui, R.id.tv_qd, R.id.iv_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_fanhui:
                showRemind("当前内容还没有保存是否退出");
                break;
            case R.id.tv_qd:
                String lvShName = etName.getText().toString().trim();
                if (!TextUtils.isEmpty(lvShName)) {
                    EventBus.getDefault().post(new MessageEvent(AppConstant.LVSHI_RENZHENG_NAME, lvShName));
                    finish();
                } else {
                    showCenterToast("输入不能为空");
                }
                break;
            case R.id.iv_clear:
                etName.setText("");
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showRemind("当前内容还没有保存是否退出");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
