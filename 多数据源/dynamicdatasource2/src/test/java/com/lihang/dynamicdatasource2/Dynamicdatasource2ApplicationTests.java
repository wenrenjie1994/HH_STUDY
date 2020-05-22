package com.lihang.dynamicdatasource2;

import com.lihang.dynamicdatasource2.mapper.UserMapper;
import com.lihang.dynamicdatasource2.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Dynamicdatasource2ApplicationTests {
  /*  @Autowired
    UserMapper userMapper;
    @Autowired
    @Test
    void contextLoads() {
        System.out.println(userMapper.getAll());
    }*/

    @Autowired
    UserService userService;
    @Test
    public void testservice(){
        System.out.println(userService.getAllAdminUser());
        System.out.println(userService.getAllUser());
    }

}
