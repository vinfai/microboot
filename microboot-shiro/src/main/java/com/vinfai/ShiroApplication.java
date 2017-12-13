package com.vinfai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * boot
 *
 * @author fangwenhui
 * @date 2017-12-13 19:31
 **/
@SpringBootConfiguration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan
@MapperScan("com.vinfai.dao")
public class ShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class, args);
    }
}
