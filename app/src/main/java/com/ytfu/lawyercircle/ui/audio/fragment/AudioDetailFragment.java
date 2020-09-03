package com.ytfu.lawyercircle.ui.audio.fragment;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.github.lee.annotation.InjectLayout;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.base.BaseFragment;
import com.ytfu.lawyercircle.base.BasePresenter;
import com.ytfu.lawyercircle.base.BaseView;

import butterknife.BindView;

@InjectLayout(R.layout.fragment_audio_detail)
public class AudioDetailFragment extends BaseFragment<BaseView, BasePresenter<BaseView>> {

    private static final String KEY_DETAIL = "DETAIL";

    @BindView(R.id.tv_detail)
    TextView tv_detail;

    public static AudioDetailFragment newInstance(String detail) {
        Bundle args = new Bundle();
        args.putString(KEY_DETAIL, detail);
        AudioDetailFragment fragment = new AudioDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initData() {
        super.initData();
        tv_detail.setText(Html.fromHtml(getArgumentString(KEY_DETAIL, "")));
        hideLoading();
    }
}
