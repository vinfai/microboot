package com.vinfai.topic;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * adduser topic
 *
 * @author fangwenhui
 * @date 2017-12-04 15:42
 **/
@Component
@RabbitListener(queues = {"test_add_user_all"})
public class AddUserReceiver {

    /*@RabbitHandler
    public void receive(String context) {
        System.out.println("add user receive message:" + context);
    }*/
    @RabbitHandler
    public void receiveWithException(String context) {
        System.out.println("add user receive message:" + context);
        //消息会不断重新发送！
        //throw new RuntimeException("runtime exception.");
        //RabbitMQ 就会把该条信息放入到死信队列中
        throw new AmqpRejectAndDontRequeueException("e");
    }
}
