package com.vinfai.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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


  /*  @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(vhost);
        return connectionFactory;
    }*/

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
    Binding binding(Queue userPointQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(userPointQueue).to(topicExchange).with(addUserPointRouteKey);
    }

    @Bean
    Binding bindingTestQueue(Queue userQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(userQueue).to(topicExchange).with(addUserRouteKey);
    }



}
