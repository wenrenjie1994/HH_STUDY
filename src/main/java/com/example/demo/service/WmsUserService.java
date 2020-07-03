package com.example.demo.service;

import com.example.demo.model.User;

import java.util.ArrayList;

public interface WmsUserService {
    ArrayList<User> findAll();
    /**
     * 选择指定 id 的 user 信息
     *
     * @param userID 用户ID
     * @return 返回指定 userID 对应的 user 信息
     */
    User selectByUserID(Integer userID);

    /**
     * 选择指定 userName 的 user 信息
     *
     * @param userName 用户名
     * @return 返回指定 userName 对应的 user 信息
     */
    User selectByName(String userName);

    void update(User user);

    /**
     * 删除指定 id 的user 信息
     *
     * @param id 用户ID
     */
    void deleteById(Integer id);

    /**
     * 插入一个 user 对象信息
     * 不需指定对象的主键id，数据库自动生成
     *
     * @param user 需要插入的用户信息
     */
    void insert(User user);
    /**
     * 用户输入姓名和密码进行登录
     * @param userName 需要输入的名字
     * @param password 需要输入的密码
     */
    User selectByNameAndPassword(String userName, String password);

}
