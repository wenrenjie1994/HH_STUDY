package com.lihang.dynamicdatasource.springboot;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/21
 */
@Configuration
@MapperScan(value = "com.lihang.dynamicdatasource.springboot.mapper2",sqlSessionFactoryRef = "sqlSessionFactoryBean2")
public class MybatisConfigTwo {
    @Autowired
    @Qualifier("dsTwo")
    DataSource dsTwo;

    @Bean
    SqlSessionFactory sqlSessionFactoryBean2() throws Exception {
        System.out.println(dsTwo);
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dsTwo);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResource("classpath:mapper/AdminMapper.xml"));
        return factoryBean.getObject();
    }


}
