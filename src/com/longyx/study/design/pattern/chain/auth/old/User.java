package com.longyx.study.design.pattern.chain.auth.old;

import java.io.Serializable;

/**
 *@author Mr.Longyx
 * @date 2020年07月10日 20:40
 */
public class User implements Serializable {
    private static final long serialVersionUID = 8709116187974400709L;
    private String username;
    private String password;
    private String roleName;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
