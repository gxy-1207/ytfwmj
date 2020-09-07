package com.ytfu.lawyercircle.ui.users.act;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.github.lee.annotation.InjectLayout;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.base.BaseActivity;

import butterknife.BindView;
import qiu.niorgai.StatusBarCompat;

/** @Auther gxy @Date 2020/6/12 @Des 公告详情 */
@InjectLayout(
        value = R.layout.activity_announcement_details,
        toolbarLayoutId = R.layout.layout_toolbar_center_title)
public class AnnouncementDetailsActivity extends BaseActivity {
    @BindView(R.id.web_view)
    WebView webView;

    private static final String KEY_URL = "URL";
    private static final String KEY_TITLE = "KEY_TITLE";

    public static void start(Context context, String url) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_URL, url);
        Intent starter = new Intent(context, AnnouncementDetailsActivity.class);
        starter.putExtras(bundle);
        context.startActivity(starter);
    }

    public static void start(Context context, String title, String url) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_TITLE, title);
        bundle.putString(KEY_URL, url);
        Intent starter = new Intent(context, AnnouncementDetailsActivity.class);
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
        String title = getBundleString(KEY_TITLE, "公告详情");
        setToolbarText(R.id.tv_global_title, title);
        setToolbarTextColor(R.id.tv_global_title, getResources().getColor(R.color.textColor_33));
        webView.setHorizontalScrollBarEnabled(false); // 水平不显示
        webView.setVerticalScrollBarEnabled(false); // 垂直不显示
        String url = getBundleString(KEY_URL, "");
        // WebSetting
        WebSettings ws = webView.getSettings();
        ws.setAllowFileAccess(true);
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        ws.setSupportZoom(false);
        ws.setBuiltInZoomControls(false);
        ws.setUseWideViewPort(true);
        ws.setSupportMultipleWindows(false);
        ws.setAppCacheEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setJavaScriptEnabled(true);
        ws.setGeolocationEnabled(true);
        ws.setAppCacheMaxSize(Long.MAX_VALUE);
        ws.setAppCachePath(getDir("app_cache", 0).getPath());
        ws.setDatabasePath(getDir("database", 0).getPath());
        ws.setGeolocationDatabasePath(this.getDir("geolocation", 0).getPath());
        ws.setPluginState(WebSettings.PluginState.ON_DEMAND);
        ws.setRenderPriority(WebSettings.RenderPriority.HIGH);
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().sync();

        if (TextUtils.isEmpty(url)) {
            showEmpty();
        } else {
            webView.loadUrl(url);
        }
    }
}
