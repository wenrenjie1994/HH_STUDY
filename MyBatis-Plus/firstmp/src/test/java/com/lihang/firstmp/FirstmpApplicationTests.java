package com.lihang.firstmp;

import com.lihang.firstmp.dao.UserMapper;
import com.lihang.firstmp.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class FirstmpApplicationTests {
    @Autowired
   private UserMapper userMapper;


    @Test
    public void insertOne(){
        User user = new User();
        //user.setUserId(1088248166370883943L);
        user.setName("明镜");
        user.setAge(36);
        user.setEmail("ml@baomidou.com");
        user.setManagerId(1264846049184292866L);
        int rows = userMapper.insert(user);
        System.out.println("影响行数："+rows);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(1088248166370832179L);
        user.setCreateTime(LocalDateTime.now());
        int rows = userMapper.updateById(user);
        System.out.println("影响行数："+rows);
    }

}
