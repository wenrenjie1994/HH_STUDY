package com.spdb.study.design.pattern.builder.general;

import java.io.Serializable;

/**
 * 需要构建的产品目标类
 * @author Mr.Longyx
 * @date 2020年07月15日 8:43
 */
public class Book implements Serializable {
    private static final long serialVersionUID = -5425354680128382659L;

    private String name;
    private String author;
    private Double price;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
