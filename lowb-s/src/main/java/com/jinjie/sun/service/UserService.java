package com.jinjie.sun.service;

import com.jinjie.sun.pojo.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    int add(User user);

    int update(User user);

    int delete(Long id);

    User findUser(Long id);

    List<User> findUserList();
}
