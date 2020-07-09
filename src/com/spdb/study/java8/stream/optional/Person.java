package com.spdb.study.java8.stream.optional;

import java.util.Optional;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 22:36
 */
public class Person {
    private Optional<Car> car;
    public Optional<Car> getCar(){
        return this.car;
    }
}
