package com.vinfai.simple;

import com.vinfai.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * mq sender
 *
 * @author fangwenhui
 * @date 2017-12-04 14:12
 **/
@Service("helloSender")
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = Math.random()+"hello" + new Date();
        rabbitTemplate.convertAndSend(RabbitMQConfig.helloQueueName, context);
    }
}
