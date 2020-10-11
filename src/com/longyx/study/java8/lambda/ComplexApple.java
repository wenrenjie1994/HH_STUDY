package com.longyx.study.java8.lambda;

import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 12:32
 */
public class ComplexApple implements Serializable {
    private static final long serialVersionUID = -6394257063857826521L;

    private String name;
    private String color;
    private Long weight;

    public ComplexApple(String name, String color, Long weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ComplexApple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
