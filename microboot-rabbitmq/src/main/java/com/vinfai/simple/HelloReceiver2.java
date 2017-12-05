package com.vinfai.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接受者
 *
 * @author fangwenhui
 * @date 2017-12-04 14:15
 **/
@Component("HelloReceiver2")
@RabbitListener(queues = {"hello_queue"})
public class HelloReceiver2 {

    @RabbitHandler
    public void receive(String context) {
        System.out.println("HelloReceiver2 receive msg:"+context);
    }
}
