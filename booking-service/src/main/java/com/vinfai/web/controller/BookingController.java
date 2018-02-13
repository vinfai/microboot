package com.vinfai.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 预定服务
 *
 * @author fangwenhui
 * @date 2018-02-13 14:57
 **/
@RestController
public class BookingController {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(String name) {
        return port+"hello,"+name;
    }
}
