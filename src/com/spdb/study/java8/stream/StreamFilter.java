package com.spdb.study.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 16:07
 */
public class StreamFilter {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,3,7,6);
        List<Integer> result = list.stream().filter(i->i%2==0).collect(toList());
        System.out.println(result);

        result = list.stream().distinct().collect(Collectors.toList());
        System.out.println(result);

        result = list.stream().skip(5).collect(Collectors.toList());
        System.out.println(result);

        result = list.stream().limit(6).collect(Collectors.toList());
        System.out.println(result);

    }
}
