package com.wormhole.framework.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: ChenYu
 * @Date: 2019/3/28 10:28
 * @Description:
 */
@Configuration
public class ShiroConfig {

    /**
     * 负责shiroBean的生命周期
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 自定义的认证类，继承自AuthorizingRealm,负责用户的认证和权限处理
     * @return
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public MyShiroRealm shiroRealm(){
        MyShiroRealm realm = new MyShiroRealm();
        return realm;
    }

    /**
     * 安全管理器
     * 讲realm加入securityManager
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        //注意是DefaultWebSecurityManager
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    /**
     * shiro filter 工厂类
     * 1.定义ShiroFilterFactoryBean
     * 2.设置SecurityManager
     * 3.配置拦截器
     * 4.返回定义ShiroFilterFactoryBean
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //注册securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //拦截器+配置登录和登录成功后的url
        //LinkedHashMap是有序的，shiro回根据添加的顺序进行拦截
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //配置不会被拦截的连接，这里顺序判断
        //anon，所有的url都可以匿名访问
        //authc：所有url都必须认证通过才可以访问
        //user，配置记住我或者认证通过才能访问
        //logout，退出登录
        filterChainDefinitionMap.put("/JQuery/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        //配置退出过滤器
        filterChainDefinitionMap.put("/example1","anon");
        filterChainDefinitionMap.put("/lxt","anon");
        filterChainDefinitionMap.put("/login","authc");
        filterChainDefinitionMap.put("/success","anon");
        filterChainDefinitionMap.put("/index","anon");
        filterChainDefinitionMap.put("/Register","anon");
        filterChainDefinitionMap.put("/logout","logout");
        //过滤连接自定义，从上往下顺序执行，所以用LinkHashMap /**放在最下边
        filterChainDefinitionMap.put("/**","authc");
        //设置登录界面，如果不设置为寻找web根目录下的文件
        shiroFilterFactoryBean.setLoginUrl("/lxt");
        //设置登录成功后要跳转的连接
        shiroFilterFactoryBean.setSuccessUrl("/success");
        //设置登录未成功，也可以说无权限界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("shiro拦截工厂注入类成功");
        return shiroFilterFactoryBean;
    }
}
