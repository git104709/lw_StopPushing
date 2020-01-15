package com.lunwei.lw_StopPushing.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.Filter;

/**
 * ClassName:    ShiroConfig
 * Package:    com.test.demo.shiro
 * Description: 重写拒绝访问后的操作
 * Datetime:    2020/1/15   12:30
 * Author:   zhoukaishun
 */
@Configuration
public class ShiroConfig {


    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/shiro/login");
        shiroFilterFactoryBean.setSuccessUrl("/shiro/success");
        //无法生效  暂未解决
        //shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/shiro/admin", "anon");

        filterChainDefinitionMap.put("/shiro/**", "authc");
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
        filterChainDefinitionMap.put("/**", "authc");

        LinkedHashMap<String, Filter> filtsMap = new LinkedHashMap<>();
        // 这里使用自定义的filter
        filtsMap.put("authc", new ShiroFormAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filtsMap);

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(customRealm());
        return defaultSecurityManager;
    }

    @Bean
    public CustomRealm customRealm() {
        CustomRealm customRealm = new CustomRealm();
        return customRealm;
    }
}
