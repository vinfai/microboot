package com.vinfai.sms.service;

/**
 * 短信服务
 *
 * @author vinfai
 * @date 2017-12-07 9:47
 **/
public interface ISmsService {

    void sendSMS(String phone, String content);
}
