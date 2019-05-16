package com.guo.school.shiro;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import com.guo.school.domain.Permission;
import com.guo.school.service.PermissionService;

/**
 * Created by yubotao on 2017/12/03.
 */
@Configuration
@Component
@Import(ShiroManager.class)
public class ShiroConfig {
    private static final Log log = LogFactory.getLog(ShiroConfig.class);
    
    @Bean(name = "realm")
    @DependsOn("lifecycleBeanPostProcessor")
    public Realm realm(){return new MyRealm();}
    @Autowired
    PermissionService permissionService;
    
    /**
     * 用户授权信息Cache
     * */
    @Bean(name = "shiroCacheManager")
    public CacheManager cacheManager(){return new MemoryConstrainedCacheManager();}
    
    @Bean(name = "securityManager")
    public DefaultSecurityManager securityManager(){
        //这里注意，需要实现DefaultWebSecurityManager
        DefaultSecurityManager sm = new DefaultWebSecurityManager();
        sm.setCacheManager(cacheManager());
        return sm;
    }
    
    /**
     * shiro核心，拦截器链，顺序执行
     * */
    @Bean(name = "shiroFilter")
    @DependsOn("securityManager")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultSecurityManager securityManager,Realm realm){
        securityManager.setRealm(realm);
        
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/login/loginpage");//未登录跳转
        shiroFilter.setUnauthorizedUrl("/login/permissionfail");//未授权跳转
        LinkedHashMap<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        
        List<Permission> permissions=permissionService.listPermissions();
        for (Iterator iterator = permissions.iterator(); iterator.hasNext();) {
			Permission permission = (Permission) iterator.next();
			filterChainDefinitionMap.put(permission.getUrl(),"perms["+permission.getCode()+"]");
		}
        
//        filterChainDefinitionMap.put("/a/u/first","perms[1]");
//        log.info("第一链");
//        filterChainDefinitionMap.put("/a/u/second","perms[2]");
//        log.info("第二链");
//        filterChainDefinitionMap.put("/a/u/third","perms[3]");
//        log.info("第三链");
        
        filterChainDefinitionMap.put("//**","anon");
        
        log.info("执行顺序 : " + filterChainDefinitionMap);
        
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilter;
    }
    
    
}
