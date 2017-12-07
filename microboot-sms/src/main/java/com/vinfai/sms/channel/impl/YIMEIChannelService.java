package com.vinfai.sms.channel.impl;

import com.vinfai.sms.channel.ISmsChannelService;
import org.springframework.stereotype.Component;

/**
 * 渠道具体实现
 *
 * @author vinfai
 * @date 2017-12-06 17:53
 **/
@Component("YIMEIChannelService")
public class YIMEIChannelService implements ISmsChannelService {

    @Override
    public String sendSMS(String phone, String content) {
        System.out.println("send sms by yi mei.");
        return null;
    }
}
