package com.vinfai.sms.route;

/**
 * 短信渠道选择
 * @author vinfai
 * @date 2017.12.06
 */
public interface ISmsChannelRoutingRule {

    /**
     * 选择短信渠道
     * @return 渠道KEY
     */
    String selectSmsChannel();

}
