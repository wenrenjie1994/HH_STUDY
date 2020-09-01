package com.spdb.study.java8.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 17:07
 */
public class StreamReduce {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        Integer result = stream.reduce(0,(i,j)->i+j);
        System.out.println(result);

        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        stream.reduce((i,j)->i+j).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        Optional<Integer> res = stream.reduce(Integer::sum);
        System.out.println(res.get());

        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        stream.reduce((i,j)->i>j?i:j).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        stream.reduce(Integer::max).ifPresent(System.out::println);


        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        stream.reduce(Integer::min).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        int rs = stream.filter(i->i % 2 == 0).reduce(1,(i,j)->i * j);
        System.out.println(rs);
    }
}
