package com.lihang.dynamicdatasource.springboot.mapper2;

import com.lihang.dynamicdatasource.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/21
 */
@Mapper
public interface AdminMapper {
   public List<User> getAllUsers();
}
