/*
package com.example.springboot.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Arrays;

*/
/**
 * @author jiangtingfeng
 * @description 配置拦截类管理类
 * @date 2020/1/7/007
 *//*

@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        String[] add = new String[]{
                //静态资源
                "/web-inf/jsp/",
                "/login",
                "/user/login",
                "/user/test"
        };
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns(Arrays.asList(add));
        super.addInterceptors(registry);
    }
}
*/
