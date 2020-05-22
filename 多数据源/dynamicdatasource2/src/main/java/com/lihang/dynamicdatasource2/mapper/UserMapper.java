package com.lihang.dynamicdatasource2.mapper;

import com.lihang.dynamicdatasource2.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/21
 */

public interface UserMapper {
    List<User> getAll();
}
