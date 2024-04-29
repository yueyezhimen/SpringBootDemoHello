package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author futao
 * Created on 2018/9/18-15:15.
 */
@SpringBootConfiguration
public class WebMvcConfiguration implements WebMvcConfigurer {
	@Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * addInterceptor()的顺序需要严格按照程序的执行的顺序
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(this.loginInterceptor).excludePathPatterns(new String[]{"/login/index", "/login/login", "/layuiadmin/**", "/show/**", "/error"}).addPathPatterns(new String[]{"/**"});
    }
}