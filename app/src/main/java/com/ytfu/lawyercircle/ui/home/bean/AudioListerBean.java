package com.ytfu.lawyercircle.ui.home.bean;
//听取音频时长的bean
public class AudioListerBean {

    /**
     * status : 1
     * referer :
     * state : success
     */

    private int status;
    private String referer;
    private String state;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
