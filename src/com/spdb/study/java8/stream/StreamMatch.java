package com.spdb.study.java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 16:40
 */
public class StreamMatch {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});

        boolean matched = stream.allMatch(i->i>0);
        assert matched : "some contents not matched.";

        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        matched = stream.anyMatch(i->i>8);
        System.out.println(matched);

        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        boolean match = stream.noneMatch(i->i<0);
        System.out.println(match);

    }
}
