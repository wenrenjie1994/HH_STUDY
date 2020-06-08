package com.example.demo.bootstrap;

import com.example.demo.service.CalculatorService;
import com.example.demo.service.impl.Java7CalculatorServiceImpl;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: A wei
 * @Date: 2020/6/7 15:41
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "com.example.demo.service")

public class CalculatorServiceBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculatorServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("java8")
                .run(args);

        CalculatorService calculatorService = context.getBean(CalculatorService.class);

        System.out.println("calculatorService sum(1..10):" + calculatorService.sum(1,2,3,4,5,6,7,8,9,10));



        context.close();
    }
}
