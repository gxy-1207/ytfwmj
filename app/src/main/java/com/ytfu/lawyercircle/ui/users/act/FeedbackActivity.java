package com.ytfu.lawyercircle.ui.users.act;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.github.lee.annotation.InjectLayout;
import com.github.lee.annotation.InjectPresenter;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BaseActivity;
import com.ytfu.lawyercircle.ui.users.bean.FeedBackBean;
import com.ytfu.lawyercircle.ui.users.p.FeedBackPresenter;
import com.ytfu.lawyercircle.ui.users.v.FeedBackView;
import com.ytfu.lawyercircle.utils.SpUtil;
import com.ytfu.lawyercircle.utils.ToastUtil;

import qiu.niorgai.StatusBarCompat;

@InjectLayout(
        value = R.layout.activity_feedback,
        toolbarLayoutId = R.layout.layout_toolbar_center_title)
@InjectPresenter(FeedBackPresenter.class)
public class FeedbackActivity extends BaseActivity<FeedBackView, FeedBackPresenter>
        implements FeedBackView {

    private EditText etShuru, et_name_input, et_phone_input;
    private static final String KEY_TYPE = "TYPE";

    public static void start(Context context, int type) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_TYPE, type);
        Intent starter = new Intent(context, FeedbackActivity.class);
        starter.putExtras(bundle);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {
        super.initData();

        StatusBarCompat.setStatusBarColor(this, Color.WHITE);
        changeStatusBarTextColor(true);
        setToolbarBackgroud(Color.WHITE);
        setToolbarLeftImage(R.drawable.fanhui_hui, view -> onBackPressed());
        setToolbarTextColor(
                R.id.tv_global_title, getResources().getColor(R.color.textColoe_303030));
        setToolbarText(R.id.tv_global_title, "我要投诉");
        etShuru = findViewById(R.id.et_shuru);
        et_name_input = findViewById(R.id.et_name_input);
        et_phone_input = findViewById(R.id.et_phone_input);
        TextView tvGeshu = findViewById(R.id.tv_geshu);
        etShuru.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(
                            CharSequence s, int start, int count, int after) {}

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {}

                    @Override
                    public void afterTextChanged(Editable s) {
                        Editable text = etShuru.getText();
                        int length = text.length();
                        tvGeshu.setText(length + "" + "/200字");
                        if (length > 200) {
                            ToastUtil.showCenterToast("超出字数限制");
                            int selEndIndex = Selection.getSelectionEnd(text);
                            String str = text.toString();
                            // 截取新字符串
                            String newStr = str.substring(0, 200);
                            etShuru.setText(newStr);
                            text = etShuru.getText();

                            // 新字符串的长度
                            int newLen = text.length();
                            // 旧光标位置超过字符串长度
                            if (selEndIndex > newLen) {
                                selEndIndex = text.length();
                            }
                            // 设置新光标所在的位置
                            Selection.setSelection(text, selEndIndex);
                        }
                    }
                });
    }

    @Override
    protected void setViewListener() {
        super.setViewListener();
        findViewById(R.id.tv_tijiao)
                .setOnClickListener(
                        view -> {
                            String uid = SpUtil.getString(mContext, AppConstant.UID, "");
                            String name = et_name_input.getText().toString();
                            String phone = et_phone_input.getText().toString();
                            String content = etShuru.getText().toString();
                            int type = getBundleInt(KEY_TYPE, -1);
                            if (TextUtils.isEmpty(name)) {
                                showToast("请输入姓名");
                                return;
                            }
                            if (TextUtils.isEmpty(phone)) {
                                showToast("请输入电话");
                                return;
                            }
                            if (TextUtils.isEmpty(content)) {
                                showToast("请输入投诉内容");
                                return;
                            }
                            getPresenter().setFeedBack(uid, content, phone, name, type);
                        });
    }

    @Override
    public void onFeekBackSuccess(FeedBackBean feedBackBean) {
        finish();
    }

    @Override
    public void onFeekBackError() {}
}
