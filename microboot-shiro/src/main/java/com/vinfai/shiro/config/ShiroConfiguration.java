package com.vinfai.shiro.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 配置
 *
 * @author fangwenhui
 * @date 2017-12-13 17:21
 **/
@Configuration
public class ShiroConfiguration {


    public static void main(String[] args) {


    }


    /**
     * 这里要解释一下：
     * anon:所有url都都可以匿名访问
     * authc:需要认证才能进行访问;
     * user:配置记住我或认证通过可以访问；
     * ShiroFilterFactoryBean处理拦截问题的时候需要注入：SecurityManager否则报错
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //Filters
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //退出
        filterChainDefinitionMap.put("/logout", "logout");

        filterChainDefinitionMap.put("/user/**", "authc");

        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;

    }

    @Bean
    public UserRealm myUserRealm() {
        UserRealm realm = new UserRealm();
        return realm;
    }
    /**
     * securityManager bean
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myUserRealm());

        return securityManager;
    }

}
