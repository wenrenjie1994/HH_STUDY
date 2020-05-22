package com.lihang.dynamicdatasource2.service;

import com.lihang.dynamicdatasource2.annotation.MyDataSource;
import com.lihang.dynamicdatasource2.mapper.AdminMapper;
import com.lihang.dynamicdatasource2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/21
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    AdminMapper adminMapper;
   @MyDataSource(name = "one")
    public String getAllUser(){
       return userMapper.getAll().toString();
    }
   @MyDataSource(name = "two")
    public String getAllAdminUser(){
        return adminMapper.getAll().toString();
    }

}
