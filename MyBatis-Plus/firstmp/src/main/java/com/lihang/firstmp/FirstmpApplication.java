package com.lihang.firstmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lihang.firstmp.dao")
public class FirstmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstmpApplication.class, args);
    }

}
