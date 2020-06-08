package com.example.demo.web.servlet.bootstrap;


import com.example.demo.web.servlet.annotation.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConditionalConfigurationBootstrap {

    /*
     *@Author: A wei
     *@Description //条件装配
     *@return  String
     *@param
     **/
    @Bean
    @ConditionalOnSystemProperty(name = "user.name",value = "Administrator")
    public  String helloWorld(){
        return "Hello world 2020";
    }

    /*
     *@Author: A wei
     *@Description //上下文装配Bean
     *@return
     *@param
     **/
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld",String.class);

        System.out.println(helloWorld);
        context.close();
    }
}
