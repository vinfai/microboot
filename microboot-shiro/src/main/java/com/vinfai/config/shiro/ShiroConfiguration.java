package com.vinfai.config.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
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
 *http://blog.csdn.net/xtiawxf/article/details/52571949
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

       // filterChainDefinitionMap.put("/user/**", "authc");

        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        //TODO READ FROM DB.RESOURCES.
        filterChainDefinitionMap.put("/admin/user/index", "perms[system:user:index]");
        filterChainDefinitionMap.put("/admin/user/add", "perms[system:user:add]");
        filterChainDefinitionMap.put("/admin/user/edit*", "perms[system:user:edit]");
        filterChainDefinitionMap.put("/admin/user/deleteBatch", "perms[system:user:deleteBatch]");
        filterChainDefinitionMap.put("/admin/user/grant/**", "perms[system:user:grant]");

        filterChainDefinitionMap.put("/admin/role/index", "perms[system:role:index]");
        filterChainDefinitionMap.put("/admin/role/add", "perms[system:role:add]");
        filterChainDefinitionMap.put("/admin/role/edit*", "perms[system:role:edit]");
        filterChainDefinitionMap.put("/admin/role/deleteBatch", "perms[system:role:deleteBatch]");
        filterChainDefinitionMap.put("/admin/role/grant/**", "perms[system:role:grant]");

        filterChainDefinitionMap.put("/admin/resource/index", "perms[system:resource:index]");
        filterChainDefinitionMap.put("/admin/resource/add", "perms[system:resource:add]");
        filterChainDefinitionMap.put("/admin/resource/edit*", "perms[system:resource:edit]");
        filterChainDefinitionMap.put("/admin/resource/deleteBatch", "perms[system:resource:deleteBatch]");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;

    }

    @Bean(name="credentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //散列的次数，比如散列两次，相当于 md5(md5(""));
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(1);
        //storedCredentialsHexEncoded默认是true，此时用的是密码加密用的是Hex编码；false时用Base64编码
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;

    }

    @Bean
    public UserRealm myUserRealm() {
        UserRealm realm = new UserRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        // realm.setCacheManager(ehCacheManager);
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
