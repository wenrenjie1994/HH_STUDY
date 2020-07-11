package com.spdb.study.design.pattern.iterator.book;

import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 13:14
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 7880180174038677381L;

    private String name;

    public Book(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
