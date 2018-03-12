package com.vinfai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册服务
 *
 * @author fangwenhui
 * @date 2018-02-13 10:49
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaRegistry {

    public static void main(String[] args) {
        System.out.println("push test.");
        SpringApplication.run(EurekaRegistry.class, args);
    }
}
