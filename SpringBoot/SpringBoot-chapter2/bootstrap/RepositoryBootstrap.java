package com.example.demo.bootstrap;

import com.example.demo.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Author: A wei
 * @Date: 2020/6/7 10:08
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */
@ComponentScan(basePackages = "package com.example.demo.repository")
public class RepositoryBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);


        MyFirstLevelRepository myFirstLevelRepository = context.getBean("myFirstLevelRepositpry",MyFirstLevelRepository.class);

        System.out.println(myFirstLevelRepository.toString());





        context.close();
    }
}
