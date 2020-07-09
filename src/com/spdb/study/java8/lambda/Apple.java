package com.spdb.study.java8.lambda;

import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 21:55
 */
public class Apple implements Serializable {
    private static final long serialVersionUID = -4740007642255799595L;

    private String color;
    private Long weight;

    public Apple(String color, Long weight) {
        this.color = color;
        this.weight = weight;
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
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
