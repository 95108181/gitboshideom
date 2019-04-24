package com.boshi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

  /**
   * 配置静态资源
   */
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    super.addResourceHandlers(registry);
  }

  public void addInterceptors(InterceptorRegistry registry) {
    //addPathPatterns 用于添加拦截规则
    //excludePathPatterns 用于排除拦截
    registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/login")//登录页
        .excludePathPatterns("/comment/sendCode")//发送验证码
        .excludePathPatterns("/user/login");//登录页

    super.addInterceptors(registry);
  }
}
