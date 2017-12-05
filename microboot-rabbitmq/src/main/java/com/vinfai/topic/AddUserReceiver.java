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
@RabbitListener(containerFactory = "myRabbitListenerContainerFactory",queues = {"test_add_user_all"})
public class AddUserReceiver {

    @RabbitHandler
    public void receive(String context) {
        try {
            System.out.println("add user receive message:" + context);
        } catch (Exception e) {
            //1.记录错误日志，业务参数到数据库；便于后期重试或者其他操作
            //2.避免 acknowledge-mode =auto 时，MQ不断的自动重试！（手动ACK）
            //3.
        }
    }
    /*@RabbitHandler
    public void receiveWithException(String context) {
        System.out.println("add user receive message:" + context);
        //消息会不断重新发送！
        //throw new RuntimeException("runtime exception.");
        //RabbitMQ 就会把该条信息放入到死信队列中,需要配置DLQ
        throw new AmqpRejectAndDontRequeueException("e");
    }*/
}
