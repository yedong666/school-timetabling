package com.yxw.managesystem.config;

import com.yxw.managesystem.filter.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Autowired
    private AuthorizationFilter authorizationFilter;
    /**
     * 注册过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean<AuthorizationFilter> whitelistFilterRegistrationBean() {
        FilterRegistrationBean<AuthorizationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(authorizationFilter);
        registrationBean.addUrlPatterns("/*"); // 过滤的URL模式，这里设置为全部URL
        return registrationBean;
    }
}







