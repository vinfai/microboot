package com.vinfai.sms.service.impl;

import com.vinfai.sms.partner.ISmsChannelService;
import com.vinfai.sms.route.ISmsChannelRoutingRule;
import com.vinfai.sms.route.SmsChannelRouteContext;
import com.vinfai.sms.route.impl.SimpleSmsChannelRoutingRule;
import com.vinfai.sms.service.ISmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 短信服务实现
 *
 * @author fangwenhui
 * @date 2017-12-07 9:50
 **/
@Service("smsService")
public class SmsServiceImpl implements ISmsService {

    @Autowired
    @Qualifier("smsChannelRouteContext")
    private SmsChannelRouteContext routeContext;

    @Override
    public void sendSMS(String phone, String content) {
        //TODO 根据配置获取路由策略
        ISmsChannelRoutingRule channelRoutingRule = new SimpleSmsChannelRoutingRule();
//        SmsChannelRouteContext routeContext = new SmsChannelRouteContext(new SimpleSmsChannelRoutingRule());

        ISmsChannelService smsChannelService = routeContext.getSmsChannelService(channelRoutingRule);
        if (smsChannelService != null) {
            smsChannelService.sendSMS(phone, content);
        }

    }


}
