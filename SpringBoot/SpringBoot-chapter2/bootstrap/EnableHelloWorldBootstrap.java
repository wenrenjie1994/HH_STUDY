package com.example.demo.bootstrap;

import com.example.demo.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: A wei
 * @Date: 2020/6/7 11:27
 * @Last Modified by:
 * @last Modified date:
 * @Description: 注解驱动方式
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String hello = context.getBean("helloWorld",String.class);

        System.out.println("hello world Bean:" + hello);


        context.close();
    }

}
