package com.vinfai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 预定服务
 *
 * @author fangwenhui
 * @date 2018-02-13 14:38
 **/
@SpringBootApplication
@EnableEurekaClient
public class BookingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingServiceApplication.class, args);
    }
}
