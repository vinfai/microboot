package com.vinfai.sms.route;

import com.vinfai.sms.constant.SmsChannelEnum;
import com.vinfai.sms.partner.ISmsChannelService;
import com.vinfai.sms.partner.impl.YIMEIChannelService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 路由上下文
 *
 * @author fangwenhui
 * @date 2017-12-06 17:59
 **/
@Component("smsChannelRouteContext")
public class SmsChannelRouteContext implements InitializingBean{
    @Autowired
    @Qualifier("YIMEIChannelService")
    private ISmsChannelService smsYIMEIChannelService;

    private Map<String, ISmsChannelService> channelMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        channelMap.put(SmsChannelEnum.YIMEI.getKey(), smsYIMEIChannelService);
    }

    private ISmsChannelRoutingRule channelRoutingRule;
    /*  //TODO spring 初始化2个bean，和key 关联
      private Map<String, ISmsChannelService> map = new HashMap<>();
      {

          map.put(SmsChannelEnum.YIMEI.getKey(), new YIMEIChannelService());
      }
       public SmsChannelRouteContext(ISmsChannelRoutingRule channelRoutingRule) {
        this.channelRoutingRule = channelRoutingRule;
    }


  */

    public ISmsChannelService getSmsChannelService(ISmsChannelRoutingRule channelRoutingRule) {
        return getChannelByKey(channelRoutingRule.selectSmsChannel());
    }

    private ISmsChannelService getChannelByKey(String key) {
        ISmsChannelService smsChannelService = channelMap.get(key);
        return smsChannelService;
    }

}
