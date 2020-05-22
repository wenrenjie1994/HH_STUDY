package com.lihang.dynamicdatasource2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude =DataSourceAutoConfiguration.class)
@MapperScan("com.lihang.dynamicdatasource2.mapper")
public class Dynamicdatasource2Application {

    public static void main(String[] args) {
        SpringApplication.run(Dynamicdatasource2Application.class, args);
    }

}
