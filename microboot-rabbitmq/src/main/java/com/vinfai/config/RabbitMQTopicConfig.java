package com.vinfai.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * topic test
 *
 * @author fangwenhui
 * @date 2017-12-04 15:31
 **/
@Component
public class RabbitMQTopicConfig {


    public static String topicExchange = "testTopicExchange";

    /**
     * topic路由规则;test.addUser.# 能匹配到key：test.addUser.point。2个队列都能接收到数据
     */
    public static String addUserRouteKey= "test.addUser.#";

    public static String addUserPointRouteKey = "test.addUser.point";

    public static String testPointQueueName = "test_add_user_point";

    public static String testUserQueueName = "test_add_user_all";
    public static String dxlRouteKey = "dlxRouteKey1";
    public static String delayRouteKey = "delayRouteKey2";

    @Bean
    public TopicExchange delayExchange() {
        return new TopicExchange("dlxexchange");
    }

    //create dlq
    @Bean
    Queue dlxQueue() {
        Map<String, Object> args = new HashMap<>();
        Queue queue =  new Queue("dlxQueue", true, false, false, args);
        return queue;
    }
    @Bean
    Binding bindingDlxQueue(Queue dlxQueue, TopicExchange delayExchange) {
        return BindingBuilder.bind(dlxQueue).to(delayExchange).with(dxlRouteKey);
    }


    @Bean
    Queue delay1mQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 100*1000);
        args.put("x-dead-letter-exchange","dlxexchange");
        args.put("x-dead-letter-routing-key",dxlRouteKey);/**/
        Queue queue =  new Queue("delay.1m.queue", true, false, false, args);
        return queue;
    }
    //队列绑定到死信队列 dlxExchange -> dlxRouteKey



    @Bean
    Binding bindingDelay1mQueue(Queue delay1mQueue, TopicExchange exchange) {
        return BindingBuilder.bind(delay1mQueue).to(exchange).with(delayRouteKey);
    }




    @Bean
    Queue userPointQueue() {
        return new Queue(testPointQueueName, true);
    }

    @Bean
    Queue userQueue() {
        return new Queue(testUserQueueName, true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchange);
    }


    @Bean
    Binding binding(Queue userPointQueue, TopicExchange exchange) {
        return BindingBuilder.bind(userPointQueue).to(exchange).with(addUserPointRouteKey);
    }

    @Bean
    Binding bindingTestQueue(Queue userQueue, TopicExchange exchange) {
        return BindingBuilder.bind(userQueue).to(exchange).with(addUserRouteKey);
    }






}
