package com.vinfai.config;

import com.vinfai.web.interceptor.ContextInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author fangwenhui
 * @date 2017-12-15 18:39
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    ContextInterceptor contextInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(contextInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/static/assets/**");
        super.addResourceHandlers(registry);
    }*/
}
