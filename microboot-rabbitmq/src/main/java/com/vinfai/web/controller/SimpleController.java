package com.vinfai.web.controller;

import com.vinfai.topic.UserInfoSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * send
 *
 * @author fangwenhui
 * @date 2018-03-13 17:16
 **/
@RestController
public class SimpleController {


    @Autowired
    private UserInfoSender userInfoSender;

    @RequestMapping("/send")
    public String send() throws InterruptedException {

        while (true) {
            userInfoSender.sendUserPoint();
            Thread.sleep(1000 * 30);
        }
    }

    @RequestMapping("/send2")
    public String send2() throws InterruptedException {

        while (true) {
            userInfoSender.sendDelayMessage2Queue();
            Thread.sleep(1000 * 30);
        }
    }
}
