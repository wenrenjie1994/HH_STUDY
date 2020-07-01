package com.spdb.study.design.pattern.template.jdbc.dao;

import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年07月01日 14:16
 */
public class User implements Serializable {
    private static final long serialVersionUID = -1185459882784328154L;

    private String username;
    private String password;
    private int age;
    private String addr;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
