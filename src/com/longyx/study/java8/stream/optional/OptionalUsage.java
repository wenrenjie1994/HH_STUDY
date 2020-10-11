package com.longyx.study.java8.stream.optional;

import java.util.Optional;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 22:48
 */
public class OptionalUsage {
    public static void main(String[] args) {
        Optional<Insurance> insurance = Optional.of(new Insurance());

        Optional<String> ins = insurance.map(i -> i.getName());
        System.out.println(ins.orElse("None Value"));
        System.out.println(ins.isPresent());

        ins.ifPresent(System.out::println);

        System.out.println(getName(null));
        System.out.println(getInsuranceNameByOptional(null));
    }

    private static String getName(Insurance insurance){
        if (null == insurance){
            return "unknown";
        }
        return insurance.getName();
    }

    private static String getInsuranceNameByOptional(Insurance insurance){
        return Optional.ofNullable(insurance).map(Insurance::getName).orElse("unknown");
    }
}
