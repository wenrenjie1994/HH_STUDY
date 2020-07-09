package com.spdb.study.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 16:48
 */
public class StreamFind {
    public static void main(String[] args) {
        Stream<Integer> stream =  Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});

        Optional<Integer> optionalInt = stream.filter(i -> i % 2 == 0).findAny();
        System.out.println(optionalInt.orElse(-1));
        System.out.println(optionalInt.get());

        stream =  Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        Optional<Integer> op = stream.filter(i -> i % 2 == 1).findFirst();
        System.out.println(op.isPresent());
        System.out.println(op.get());

       int result =  find(new Integer[]{1,2,3,4,5,6,7,8,9},-1,i->i > 7);
        System.out.println(result);
    }

    private static int find(Integer[] values, int defaultValue, Predicate<Integer> predicate){
        for( int i : values){
            if (predicate.test(i)){
                return i;
            }
        }
        return defaultValue;
    }

}
