package com.vinfai.topic;

import com.vinfai.config.RabbitMQTopicConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * user topic test
 *
 * @author fangwenhui
 * @date 2017-12-04 15:36
 **/
@Component
public class UserInfoSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage2DelayQueue() {
        CorrelationData data = new CorrelationData();
        data.setId(new Random().nextInt(1000)+"");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String t = format.format(new Date());

        String context = "{userid:1,point:100,sendtime:%s}";
        context = String.format(context, t);
        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.topicExchange, RabbitMQTopicConfig.delayRouteKey, context, data);

    }


    public void sendDelayMessage2Queue() {
        CorrelationData data = new CorrelationData();
        data.setId(new Random().nextInt(1000)+"");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String t = format.format(new Date());

        String context = "{userid:1,point:100,sendtime:%s}";
        context = String.format(context, t);

        MessagePostProcessor postProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
//                message.getMessageProperties().setDelay(10000);
                message.getMessageProperties().setExpiration("10000");

                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            }
        };
        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.topicExchange, RabbitMQTopicConfig.delayRouteKey, context,postProcessor, data);
    }




    public void sendUserPoint() {



        CorrelationData data = new CorrelationData();
        data.setId(new Random().nextInt(1000)+"");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String t = format.format(new Date());

        String context = "{userid:1,point:100,sendtime:%s}";
        context = String.format(context, t);
//        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.topicExchange, RabbitMQTopicConfig.addUserPointRouteKey, context, data);
//        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.topicExchange, "111", context, data);
//        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.topicExchange, RabbitMQTopicConfig.addUserPointRouteKey, context);
//        rabbitTemplate.s
//        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.topicExchange, "errorQueueKey", context);
//        rabbitTemplate.convertAndSend("errorExchange", RabbitMQTopicConfig.addUserPointRouteKey, context);

        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.topicExchange, RabbitMQTopicConfig.delayRouteKey, context, data);

    }

    public void sendException() {
        String context = "{userid:1,point:100}";
//        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.topicExchange, RabbitMQTopicConfig.addUserPointRouteKey, context);
        //queue not exist
        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.topicExchange, "errorQueueKey", context);
        //exchange not exist
//        rabbitTemplate.convertAndSend("errorExchange", RabbitMQTopicConfig.addUserPointRouteKey, context);

    }

    public void sendUserInfo() {

        String context = "{userid:1,point:100}";
        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.topicExchange, RabbitMQTopicConfig.addUserRouteKey, context);

    }
}
