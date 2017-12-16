package com.vinfai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * boot
 *
 * @author vinfai
 * @date 2017-12-13 19:31
 **/
@SpringBootApplication
//@EnableWebMvc
@MapperScan("com.vinfai.dao")
public class ShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class, args);
    }
}
