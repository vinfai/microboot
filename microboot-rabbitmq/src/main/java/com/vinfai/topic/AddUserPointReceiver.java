package com.vinfai.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * add point topic test
 *
 * @author fangwenhui
 * @date 2017-12-04 15:44
 **/
@Component
@RabbitListener(queues = {"test_add_user_point"})
public class AddUserPointReceiver {

    @RabbitHandler
    public void receive(String context) {
        System.out.println("AddUserPointReceiver message:"+context);
    }
}
