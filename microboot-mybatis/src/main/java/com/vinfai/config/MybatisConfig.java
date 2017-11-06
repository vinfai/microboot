package com.vinfai.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author vinfai
 * @since 2017-11-06
 */
@Configuration
public class MybatisConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource getDataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }


}
