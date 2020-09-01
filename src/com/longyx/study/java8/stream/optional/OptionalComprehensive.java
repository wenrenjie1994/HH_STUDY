package com.spdb.study.java8.stream.optional;

import java.util.Optional;

/**
 * You just tell "how" not "do what".
 * @author Mr.Longyx
 * @date 2020年07月07日 23:21
 */
public class OptionalComprehensive {
    public static void main(String[] args){
        System.out.println(getInsuranceByOptional(null));

        Optional.ofNullable(getInsuranceByOptional(null)).ifPresent(System.out::println);
    }
    private static String getInsuranceByOptional(Person person){
       return Optional.ofNullable(person).flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("Unknown");
    }
}
