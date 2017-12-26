package com.vinfai.sms.api;

import com.vinfai.sms.service.ISmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 对外服务
 *
 * @author vinfai
 * @date 2017-12-07 9:25
 **/
@Controller
@RequestMapping("/api")
public class SmsApiController {

    @Autowired@Qualifier("smsService")
    private ISmsService smsService;

    @RequestMapping("/sendSMS")
    @ResponseBody
    public String sendSMS(String phone,String content,String sign,String appkey,String version) {
        //TODO  api 接口如何设计 过滤器权限校验、参数校验等
        smsService.sendSMS(phone, content);
        return "success";
    }
}
