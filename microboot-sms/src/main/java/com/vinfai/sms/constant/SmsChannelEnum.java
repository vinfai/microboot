package com.vinfai.sms.constant;

/**
 * 短信渠道
 */
public enum SmsChannelEnum {

    YIMEI("YIMEI","亿美"), CHUANLAN("CHUANLAN", "创蓝");

    private String key;

    private String name;


    SmsChannelEnum(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
