package com.example.demo.service.impl;

import com.example.demo.dao.WmsUserDao;
import com.example.demo.model.User;
import com.example.demo.service.WmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class WmsUserServiceImpl implements WmsUserService {

    @Autowired
    private WmsUserDao wmsUserDao;

    @Override
    public ArrayList<User> findAll() {
        return wmsUserDao.findAll();
    }

    @Override
    public User selectByUserID(Integer userID) {
        return wmsUserDao.selectByUserID(userID);
    }

    @Override
    public User selectByName(String userName) {
        return wmsUserDao.selectByName(userName);
    }

    @Override
    public void update(User user) {
        wmsUserDao.update(user);
    }

    @Override
    public void deleteById(Integer id) {
        wmsUserDao.deleteById(id);
    }

    @Override
    public void insert(User user) {
        wmsUserDao.insert(user);
    }

    @Override
    public User selectByNameAndPassword(String userName, String password) {
        return wmsUserDao.selectByNameAndPassword(userName,password);
    }
}
