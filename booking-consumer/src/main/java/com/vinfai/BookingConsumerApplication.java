package com.vinfai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 预定服务调用者
 *
 * @author fangwenhui
 * @date 2018-02-13 15:02
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class BookingConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingConsumerApplication.class, args);

    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();
        SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory)template.getRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);
        return template;
    }
}
