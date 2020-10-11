package com.longyx.study.design.pattern.observe.advice;

import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年07月03日 14:20
 */
public class Issues implements Serializable {
    private static final long serialVersionUID = 2354053381417537551L;

    private String username;
    private String content;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
