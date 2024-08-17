package com.lgs.backend.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${upload.dir}")
    private String UPLOAD_DIR ;
    @Value("${jwt.secret.key}")
    private String secretKey;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pic/**").addResourceLocations("file:/"+UPLOAD_DIR);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor(secretKey)).addPathPatterns("/api/v1/**")
                .excludePathPatterns("/api/v1/users/login", "/api/v1/users/register","/api/v1/users/captcha");
    }
}
