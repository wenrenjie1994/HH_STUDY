package com.longyx.study.java8.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 20:53
 */
public class NumericStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        Integer result = stream.filter(i->i.intValue() > 4).reduce(0,Integer::sum);
        System.out.println(result);

        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        Stream<Integer> integerStream = stream.filter(i -> i.intValue() > 5);
        result = integerStream.reduce(0,Integer::sum);
        System.out.println(result);


        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        Optional<Integer> res = stream.filter(i->i>4).reduce((i, j)->i+j);
        System.out.println(res.get());

        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9});
        IntStream intStream = stream.mapToInt(i->i.intValue());
        result = intStream.filter(i -> i>3).sum();
        System.out.println(result);

        int a = 9;
        IntStream.rangeClosed(1,200)
                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)})
                .forEach(r -> System.out.println("a:"+r[0]+" b:"+r[1]+" c:"+r[2]));

        System.out.println("=======================");
        IntStream.rangeClosed(1,100)
                .filter(b->Math.sqrt(a*a + b*b) % 1 == 0)
                .mapToObj(b->new int[]{a,b,(int)Math.sqrt(a*a + b*b)})
                .forEach(r -> System.out.println("a:"+r[0]+" b:"+r[1]+" c:"+r[2]));
    }
}
