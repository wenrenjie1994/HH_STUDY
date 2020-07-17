package com.jinjie.sun.service;

import com.jinjie.sun.dao.UserDao;
import com.jinjie.sun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }

    @Override
    public int add(User User) {
        return this.userDao.add(User);
    }

    @Override
    public int update(User User) {
        return this.userDao.update(User);
    }

    @Override
    public int delete(Long id) {
        return this.userDao.delete(id);
    }

    @Override
    public User findUser(Long id) {
        return this.userDao.findUser(id);
    }

    @Override
    public List<User> findUserList() {
        return this.userDao.findUserList();
    }
}
