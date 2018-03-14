package com.vinfai.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fangwenhui
 * @date 2018-03-14 11:41
 **/
@Component
@RabbitListener(containerFactory = "myRabbitListenerContainerFactory",queues = {"dlxQueue"})
public class DlxConsumer {
    @RabbitHandler
    public void receive(String context) {
//        MessagingMessageListenerAdapter
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String t = format.format(new Date());
        System.out.println(t+"===========================recevie dlx message:"+context);
    }
}
