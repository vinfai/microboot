package com.vinfai.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author fangwenhui
 * @date 2018-02-13 15:14
 **/
@Controller
public class BookingConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    @ResponseBody
    public String showFromServer(String name) {
       String value =  restTemplate.getForObject("http://bookService/hello?name={1}", String.class,name);
        System.out.println(value);
        return value;
    }
}
