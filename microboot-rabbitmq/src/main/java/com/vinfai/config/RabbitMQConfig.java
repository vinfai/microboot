package com.vinfai.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq config
 *
 * @author fangwenhui
 * @date 2017-12-04 13:54
 **/
@Configuration
public class RabbitMQConfig {


    @Value("${spring.rabbitmq.addresses}")
    private String addresses;

   /* @Value("${spring.rabbitmq.host}")
    private String host;*/

    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;
    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean publisherConfirms;
    /**
     * 创建连接工厂
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setAddresses(addresses);
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        factory.setPublisherConfirms(publisherConfirms);
        //消息未成功发送的情况
        factory.setPublisherReturns(true);
        return factory;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory myRabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConcurrentConsumers(1);
//        factory.setMaxConcurrentConsumers(10);

        factory.setConnectionFactory(connectionFactory());
        return factory;
    }

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //TODO why?
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            System.out.println("================ confirm callback");
            String id = correlationData.getId();

            //能够获得本次callback的消息ID，在对应到响应的消息记录。
            if (ack) {
                //
                System.out.println("ack success."+id);
            }else{
                //1. 删除topic时候 testTopicExchange，
                /**
                 * ================
                 975
                 correlationData = CorrelationData [id=975]
                 ack = false
                 cause = channel error; protocol method: #method<channel.close>(reply-code=404, reply-text=NOT_FOUND - no exchange 'testTopicExchange' in vhost 'web', class-id=60, method-id=40)
                 ================
                 */
                System.out.println(id);
                //todo update message status.
                System.out.println("correlationData = " + correlationData);
                System.out.println("ack = " + ack);
                System.out.println("cause = " + cause);
                System.out.println("================");
            }
        });

        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            System.out.println("================return call back now");
            System.out.println("message = " + message);
            System.out.println("replyCode = " + replyCode);
            System.out.println("replyText = " + replyText);
            System.out.println("exchange = " + exchange);
            System.out.println("routingKey = " + routingKey);
            System.out.println("================");
        });

        return rabbitTemplate;

    }


    public static String helloQueueName = "hello_queue";


    @Bean
    Queue helloQueue() {
        return new Queue(helloQueueName, true);
    }



}
