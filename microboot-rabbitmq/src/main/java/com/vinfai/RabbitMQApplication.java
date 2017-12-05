package com.vinfai;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot init
 * @author vinfai
 */
@SpringBootApplication
@EnableRabbit
public class RabbitMQApplication {

	public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(RabbitMQApplication.class, args);
    }
}
