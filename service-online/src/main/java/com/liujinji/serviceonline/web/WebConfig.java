package com.liujinji.serviceonline.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// 当某页面没有数据处理的时候可以直接使用视图控制器进行转发
// 此方法可以直接在Application中进行配置
@Configuration
public class WebConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("home");
    }
}
