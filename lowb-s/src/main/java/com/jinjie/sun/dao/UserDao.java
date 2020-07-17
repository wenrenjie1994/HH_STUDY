package com.jinjie.sun.dao;

import com.jinjie.sun.pojo.User;

import java.util.List;

public interface UserDao {
    User findByUsername(String username);

    int add(User User);

    int update(User User);

    int delete(Long id);

    User findUser(Long id);

    List<User> findUserList();
}
