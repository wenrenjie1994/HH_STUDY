package com.spdb.study.design.pattern.adapter.loginadapter;

import java.io.Serializable;

/**
 * 用户实体类
 * @author Mr.Longyx
 * @date 2020年07月02日 16:18
 */
public class User implements Serializable {
    private static final long serialVersionUID = 7399989589323953396L;

    private String username;
    private String password;
    private String uid;
    private String info;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
