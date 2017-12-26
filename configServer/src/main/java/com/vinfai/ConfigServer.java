package com.vinfai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置服务启动类
 *
 * @author fangwenhui
 * @date 2017-12-25 16:49
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigServer {

    public static void main(String[] args) {

        SpringApplication.run(ConfigServer.class, args);

    }
}
