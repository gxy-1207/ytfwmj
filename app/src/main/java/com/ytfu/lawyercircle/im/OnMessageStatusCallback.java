package com.ytfu.lawyercircle.im;

public interface OnMessageStatusCallback {
    void onSuccess();

    void onError(int code, String msg);
}
