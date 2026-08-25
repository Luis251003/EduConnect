package com.luis.springboot.EduConnect.config;

import com.luis.springboot.EduConnect.interceptor.AppHeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AppHeaderInterceptor appHeaderInterceptor;

    public WebConfig(AppHeaderInterceptor appHeaderInterceptor){
        this.appHeaderInterceptor = appHeaderInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(appHeaderInterceptor);
    }
}
