package com.cssl;

import com.cssl.intercepter.myIntercepter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class webconfiguaction implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        System.out.println("添加拦截器");
        HandlerInterceptor inter = new myIntercepter();

        registry.addInterceptor(inter)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**","/images/**","/js/**","/login.html","/denglu","/regist.html","/reg");
    }
}