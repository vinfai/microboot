package com.vinfai.sms.channel.impl;

import com.vinfai.sms.channel.ISmsChannelService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 渠道具体实现
 *
 * @author vinfai
 * @date 2017-12-06 17:53
 **/
@Component("YIMEIChannelService")
@RefreshScope
public class YIMEIChannelService implements ISmsChannelService {

    @Value("${sms.yimei.url}")
    private String url;

    @Override
    public String sendSMS(String phone, String content) {
        System.out.println("send sms by yi mei.");
        System.out.println(url);

        return null;
    }




}
