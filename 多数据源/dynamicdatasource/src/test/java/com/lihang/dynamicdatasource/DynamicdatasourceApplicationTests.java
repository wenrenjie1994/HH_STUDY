package com.lihang.dynamicdatasource;

import com.lihang.dynamicdatasource.springboot.mapper1.UserMapper;
import com.lihang.dynamicdatasource.springboot.mapper2.AdminMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DynamicdatasourceApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Autowired
    AdminMapper adminMapper;
    @Test
    void testspringboot() {
        System.out.println(userMapper.getAllUsers().toString());
        System.out.println(adminMapper.getAllUsers().toString());
    }
}
