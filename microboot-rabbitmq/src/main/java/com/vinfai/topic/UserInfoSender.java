package com.vinfai.topic;

import com.vinfai.config.RabbitMQTopicConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * user topic test
 *
 * @author fangwenhui
 * @date 2017-12-04 15:36
 **/
@Component
public class UserInfoSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendUserPoint() {

        String context = "{userid:1,point:100}";

        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.topicExchange, RabbitMQTopicConfig.addUserPointRouteKey, context);
//        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.topicExchange, "errorQueueKey", context);
//        rabbitTemplate.convertAndSend("errorExchange", RabbitMQTopicConfig.addUserPointRouteKey, context);

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
