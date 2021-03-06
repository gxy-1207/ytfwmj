package com.ytfu.lawyercircle.ui.users.act;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.lee.annotation.InjectLayout;
import com.github.lee.annotation.InjectPresenter;
import com.orhanobut.logger.Logger;
import com.umeng.analytics.MobclickAgent;
import com.ytfu.lawyercircle.R;
import com.ytfu.lawyercircle.app.AppConstant;
import com.ytfu.lawyercircle.base.BaseActivity;
import com.ytfu.lawyercircle.ui.pay.PayHelper;
import com.ytfu.lawyercircle.ui.pay.bean.AccountPayResponseBean;
import com.ytfu.lawyercircle.ui.users.bean.PublicPriceBean;
import com.ytfu.lawyercircle.ui.users.p.TopPaymentPresenter;
import com.ytfu.lawyercircle.ui.users.v.TopPaymentView;
import com.ytfu.lawyercircle.utils.LoginHelper;
import com.ytfu.lawyercircle.utils.MessageEvent;
import com.ytfu.lawyercircle.utils.SpUtil;
import com.ytfu.lawyercircle.utils.dialog.DialogHelper;
import com.ytfu.lawyercircle.utils.dialog.PayDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;

/** @Auther gxy @Date 2020/6/12 @Des 置顶支付 */
@InjectLayout(
        value = R.layout.activity_pay_ment,
        toolbarLayoutId = R.layout.layout_toolbar_center_title)
@InjectPresenter(TopPaymentPresenter.class)
public class TopPaymentActivity extends BaseActivity<TopPaymentView, TopPaymentPresenter>
        implements TopPaymentView {
    private static final String KEY_TOP_ID = "TOP_ID";
    private static final String KEY_PAY_TYPE = "PAY_TYPE";

    @BindView(R.id.tv_top_content)
    TextView tvTopContent;

    @BindView(R.id.tv_top_price)
    TextView tvTopPrice;

    @BindView(R.id.ll_price)
    LinearLayout llPrice;

    @BindView(R.id.tv_top_priority)
    TextView tvTopPriority;

    @BindView(R.id.tv_pay_price)
    TextView tvPayPrice;

    @BindView(R.id.pay_now)
    TextView payNow;
    // 置顶金额
    private String topPrice;
    // 账户余额
    private String income;

    public static void start(Context context, String id, int type) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_TOP_ID, id);
        bundle.putInt(KEY_PAY_TYPE, type);
        Intent starter = new Intent(context, TopPaymentActivity.class);
        //        starter.putExtra();
        starter.putExtras(bundle);
        context.startActivity(starter);
    }

    @Override
    protected void initView() {
        super.initView();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void initData() {
        super.initData();
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.white));
        changeStatusBarTextColor(true);
        setToolbarBackgroud(getResources().getColor(R.color.white));
        setToolbarLeftImage(
                R.drawable.fanhui_hui,
                v -> {
                    onBackPressed();
                });
        setToolbarText(R.id.tv_global_title, "置顶支付");
        setToolbarTextColor(R.id.tv_global_title, getResources().getColor(R.color.textColor_33));
        // 获取置顶金额
        getPresenter().getPublicPrice();
    }

    @Override
    public void getTopPayPriec(PublicPriceBean publicPriceBean) {
        if (publicPriceBean == null) {
            showError();
            return;
        }
        topPrice = publicPriceBean.getTop();
        tvTopPrice.setText(topPrice + "元");
        tvPayPrice.setText(topPrice + "元");
    }

    @OnClick(R.id.pay_now)
    public void onViewClicked() {
        double money;
        try {
            money = Double.parseDouble(topPrice);
        } catch (NumberFormatException e) {
            showToast("应用程序出现未知错误,请稍后重试");
            return;
        }
        DialogHelper.showPayDialog(
                this,
                money,
                new PayDialog.OnCommitListener() {
                    @Override
                    public void onCommit(PayDialog.PayMethod payMethod) {
                        String uid = SpUtil.getString(mContext, AppConstant.UID, "");
                        String cosultationId = getBundleString(KEY_TOP_ID, "");
                        int type = getBundleInt(KEY_PAY_TYPE, -1);
                        switch (payMethod) {
                            case PAY_WECHAT:
                                getPresenter().payWatch(uid, cosultationId, type, 1, "", "");
                                break;
                            case PAY_ALI:
                                getPresenter().payAli(uid, cosultationId, type, 1, "", "");
                                break;
                            case PAY_SELF:
                                getPresenter().payOverage(uid, cosultationId, type, 1, "", "");
                                break;
                        }
                    }
                });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onWechatPaySuccess(MessageEvent event) {
        int what = event.getWhat();
        if (what == AppConstant.WX_PAY_SUCCESS) {
            // 更新支付成功UI显示
            //            MineConsultationListActivity.start(mContext);
            uMengPoint();
            showCenterToast("支付成功");
            finish();
        }
    }

    @Override
    public void onAwakeAli(String sign) {
        PayHelper.getInstance()
                .setIPayListener(
                        new PayHelper.IPayListener() {
                            @Override
                            public void onSuccess() {
                                showCenterToast("支付成功");
                                uMengPoint();
                                finish();
                            }

                            @Override
                            public void onResultConfirmation() {}

                            @Override
                            public void onCancel() {}

                            @Override
                            public void onFail() {
                                showToast("支付出现错误,请稍后重试");
                            }
                        });
        PayHelper.getInstance().AliPay(this, sign);
    }

    @Override
    public void onPayByAccountSuccess(AccountPayResponseBean payResponseBean) {
        if (payResponseBean.getStatus() == 1) {
            showCenterToast("余额支付成功");
            uMengPoint();
            finish();
        } else {
            showCenterToast("余额支付失败");
        }
    }
    // ===Desc:友盟埋点=================================================================
    private void uMengPoint() {
        String loginUserId = LoginHelper.getInstance().getLoginUserId();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(new Date());
        String orderid = format + loginUserId;
        double money;
        try {
            money = Double.parseDouble(topPrice);
        } catch (NumberFormatException e) {
            Logger.e("umengBuriedPoint" + "----------" + e);
            e.printStackTrace();
            return;
        }
        Map successPayMap = new HashMap();
        //        HashMap<String,Object> map = new HashMap<>();
        successPayMap.put("userid", loginUserId);
        successPayMap.put("orderid", orderid);
        successPayMap.put("item", "置顶咨询");
        successPayMap.put("amount", money);
        MobclickAgent.onEvent(this, "__finish_payment", successPayMap);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
