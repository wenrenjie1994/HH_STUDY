package com.jinjie.sun.dao;

import com.jinjie.sun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findByUsername(String username) {
        List<User> list = jdbcTemplate.query("select * from user where username = ?", new Object[]{username}, new BeanPropertyRowMapper<User>(User.class));
        if(list != null && list.size() == 1) {
            User User = list.get(0);
            return User;
        } else {
            return null;
        }
    }

    @Override
    public int add(User user) {
        return jdbcTemplate.update("insert into user(name, username, password, phone, addr, email, role) values(?, ?, ?, ?, ?, ?, ?)",
                user.getName(), user.getUsername(), user.getPassword(), user.getPhone(), user.getAddr(), user.getEmail(), user.getRole());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("update user set name = ?, password = ?, phone = ?, addr = ?, email = ?, role = ? where id = ?",
                new Object[]{user.getName(), user.getPassword(), user.getPhone(), user.getAddr(), user.getId(), user.getEmail(), user.getRole()});
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from user where id = ?", id);
    }

    @Override
    public User findUser(Long id) {
        List<User> list = jdbcTemplate.query("select * from user where id = ?", new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
        if (null != list && list.size() > 0) {
            User User = list.get(0);
            return User;
        } else {
            return null;
        }
    }

    @Override
    public List<User> findUserList() {
        List<User> list = jdbcTemplate.query("select * from user", new Object[]{}, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }
}
