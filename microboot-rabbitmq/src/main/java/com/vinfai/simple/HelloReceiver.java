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
@Component("HelloReceiver1")
@RabbitListener(queues = {"hello_queue"})
public class HelloReceiver {

    @RabbitHandler
    public void receive(String context) {
        System.out.println("HelloReceiver1 receive msg:"+context);
    }
}
