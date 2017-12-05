package com.vinfai.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.adapter.MessagingMessageListenerAdapter;
import org.springframework.stereotype.Component;

/**
 * add point topic test
 *
 * @author fangwenhui
 * @date 2017-12-04 15:44
 **/
@Component
@RabbitListener(containerFactory = "myRabbitListenerContainerFactory",queues = {"test_add_user_point"})
public class AddUserPointReceiver {

    @RabbitHandler
    public void receive(String context) {
//        MessagingMessageListenerAdapter
        System.out.println("AddUserPointReceiver message:"+context);
    }
}
