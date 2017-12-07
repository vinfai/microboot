package com.vinfai.sms.partner;

/**
 * 短信渠道发送短信服务
 * @author vinfai
 * @date  2017.12.06
 */
public interface ISmsChannelService {

    /**
     * 发送短信
     * @param phone 手机号
     * @param content 短信内容
     * @return 状态报告
     */
    String sendSMS(String phone, String content);



}
