package cn.liuhao.market.config;

import cn.liuhao.market.util.JwtHttpFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1.自定义filter拦截带jwt token的请求
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);

        Map<String, String> filterChainDefinitionMap = bean.getFilterChainDefinitionMap();

        Map<String, Filter> filter = new LinkedHashMap<>();
        filter.put("jwt", new JwtHttpFilter());
        bean.setFilters(filter);

        Map<String, String> filterChian = new LinkedHashMap<>();
        filterChian.put("/web_markert/pub/**", "anon");
        bean.setFilterChainDefinitionMap(filterChian);

        return bean;
    }

    /**
     * 配置webSecurityManager
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager getWebSecurityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        return manager;
    }

    /**
     * 不向 Spring容器中注册 JwtFilter Bean，防止 Spring 将 JwtFilter 注册为全局过滤器
     * 全局过滤器会对所有请求进行拦截，而本例中只需要拦截除 /login 和 /logout 外的请求
     * 另一种简单做法是：直接去掉 jwtFilter()上的 @Bean 注解
     */
    @Bean
    public FilterRegistrationBean<Filter> registration(JwtHttpFilter filter) {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    public JwtHttpFilter jwtFilter() {
        return new JwtHttpFilter();
    }

}
