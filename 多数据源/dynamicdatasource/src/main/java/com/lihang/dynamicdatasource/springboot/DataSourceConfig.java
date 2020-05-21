package com.lihang.dynamicdatasource.springboot;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/21
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.one")
    DataSource dsOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.two")
    DataSource dsTwo(){
        return DruidDataSourceBuilder.create().build();
    }
}
