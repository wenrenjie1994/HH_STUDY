package com.spdb.study.design.pattern.template.jdbc;

import com.spdb.study.design.pattern.template.jdbc.dao.UserDao;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年07月01日 14:20
 */
public class JdbcTemplateTest {

    public static void main(String[] args) {
        UserDao userDao = new UserDao(null);
        List<?> result = userDao.selectAll();
        System.out.println(result);
    }
}
