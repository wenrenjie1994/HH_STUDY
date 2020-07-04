package com.spdb.resume;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan(basePackages =  "com.spdb.resume.dao")
public class ResumeApplication {


    public static void main(String[] args) {

        SpringApplication.run(ResumeApplication.class, args);
    }

}
