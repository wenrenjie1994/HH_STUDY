package com.spdb.study.design.principle.compositereuse;

/**
 * 组合复用原则测试类
 * @author Mr.Longyx
 * @date 2020年06月17日 23:23
 */
public class CRPTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.setConnection(new MySQLConnection());

        userDao.addUser();
    }
}
