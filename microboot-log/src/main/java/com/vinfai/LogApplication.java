package com.vinfai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author fangwenhui
 * @date 2017-12-14 19:36
 **/
@EnableAutoConfiguration
@SpringBootConfiguration
public class LogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
    }
}
