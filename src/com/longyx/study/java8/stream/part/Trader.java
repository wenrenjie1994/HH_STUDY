package com.spdb.study.java8.stream.part;

import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 21:43
 */
public class Trader implements Serializable {
    private static final long serialVersionUID = -7538996226507931206L;
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
