package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;

/**
 * @Author: A wei
 * @Date: 2020/6/7 11:12
 * @Last Modified by:
 * @last Modified date:
 * @Description: Hello world 配置
 */

public class HelloWorldConfiguration {

    @Bean
    public String helloWorld(){
        return "Hello World 2020!";
    }

}
