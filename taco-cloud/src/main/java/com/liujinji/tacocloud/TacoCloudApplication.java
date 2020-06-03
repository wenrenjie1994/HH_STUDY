package com.liujinji.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
/*
 * @SpringBootApplication是组合注解，包含：
 * 1. @SpringBootConfiguration 将该类声明为配置类
 * 2. @EnableAutoConfiguration 启动SpringBoot的自动配置
 * 3. @ComponentScan 启用组件扫描
 */
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

}
