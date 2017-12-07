package com.vinfai.sms.route.impl;

import com.vinfai.sms.constant.SmsChannelEnum;
import com.vinfai.sms.route.ISmsChannelRoutingRule;
import org.apache.commons.lang3.StringUtils;

/**
 * 手动设置
 *
 * @author vinfai
 * @date 2017-12-06 16:58
 **/
public class SimpleSmsChannelRoutingRule implements ISmsChannelRoutingRule {
    /*
    @Value("sms.channel")
    private String channel;
    */

    @Override
    public String selectSmsChannel() {
        String channel = getChannelKeyFromProperties();
        if (StringUtils.isNoneBlank(channel)) {
            return channel;
        }
        return getDefaultChannel();
    }

    private String getDefaultChannel() {
        return SmsChannelEnum.YIMEI.getKey();
    }

    private String getChannelKeyFromProperties() {
        //需要动态读取channel（add cache）
        return null;
    }

}
