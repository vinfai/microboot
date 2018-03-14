package com.vinfai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
        SpringApplication.run(EurekaRegistry.class, args);
//        ReentrantLock lock = new ReentrantLock();
//        final Condition condition = lock.newCondition();
//        sun.misc.Launcher
//        java.lang.String
    }

}
