package com.lihang.dynamicdatasource.springboot.mapper1;

import com.lihang.dynamicdatasource.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/21
 */
@Mapper
public interface UserMapper {
    public List<User> getAllUsers();
}
