package com.hjh.h5citymanage;

import com.hjh.h5citymanage.utils.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-07-13 14:09
 */
@Configuration
public class LoginConfiguration implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/**");
        // 排除路径
        loginRegistry.excludePathPatterns("/");
        loginRegistry.excludePathPatterns("/login");
        loginRegistry.excludePathPatterns("/loginout");
        // 排除资源请求
//        loginRegistry.excludePathPatterns("/*/*.css");
//        loginRegistry.excludePathPatterns("/*/*.js");
//        loginRegistry.excludePathPatterns("/*/*.png");
//        loginRegistry.excludePathPatterns("/*/*.jpg");
//        loginRegistry.excludePathPatterns("/*/*.gif");
        loginRegistry.excludePathPatterns("/css/**");
        loginRegistry.excludePathPatterns("/js/**");
        loginRegistry.excludePathPatterns("/images/**");
        loginRegistry.excludePathPatterns("/layer-v3.1.1/**");
        loginRegistry.excludePathPatterns("/manager/**");
    }
}