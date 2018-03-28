package com.vinfai.util;

public enum LogFileName {

    USER_VISTOR("user.vistor"),
    PAY_LOG("pay.log");

    String desc;

    LogFileName(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
