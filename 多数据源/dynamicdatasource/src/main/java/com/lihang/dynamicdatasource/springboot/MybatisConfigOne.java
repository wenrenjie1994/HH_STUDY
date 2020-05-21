package com.lihang.dynamicdatasource.springboot;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/21
 */
/*分包形式，注意需添加mapp文件的位置，否则报错找不到方法*/
@Configuration
@MapperScan(value = "com.lihang.dynamicdatasource.springboot.mapper1",sqlSessionFactoryRef = "sqlSessionFactoryBean1")
public class MybatisConfigOne {
    @Autowired
    @Qualifier("dsOne")
    DataSource dsOne;

    @Bean
    @Primary
    SqlSessionFactory sqlSessionFactoryBean1() throws Exception {
        System.out.println(dsOne);
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dsOne);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResource("classpath:mapper/UserMapper.xml"));
        return factoryBean.getObject();
    }
}
