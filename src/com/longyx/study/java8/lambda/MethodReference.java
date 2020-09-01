package com.spdb.study.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法推导
 * @author Mr.Longyx
 * @date 2020年07月07日 10:12
 */
public class MethodReference {
    public static void main(String[] args) {
        Consumer<String> consumer = s-> System.out.println(s);
        useConsumer(consumer, "Hello Lambda");

        useConsumer(s-> System.out.println(s),"Hello,Java");
        useConsumer(System.out::println,"Hello Joe");

        List<Apple> apples = Arrays.asList(new Apple("Red",120L),new Apple("Yellow",240L),new Apple("cyan-blue",360L));
        apples.sort((b,a)->a.getColor().compareTo(b.getColor()));
        System.out.println(apples);

        System.out.println("=============================");
        apples.stream().forEach(a-> System.out.println(a));

        System.out.println("=============================");
        //此处进行函数推导
        apples.stream().forEach(System.out::println);

        Function<String, Integer> fun = Integer::parseInt;
        Integer result = fun.apply("999");
        System.out.println(result);

        BiFunction<String, Integer, Character> f2 = String::charAt;
        Character c = f2.apply("Java",2);
        System.out.println(c);

        String str = new String("Java");
        Function<Integer, Character> f3 = str::charAt;
        Character c1 = f3.apply(3);
        System.out.println(c1);

        Supplier<String> supplier = String::new;
        String s = supplier.get();
        System.out.println(s.getClass());

        BiFunction<String, Long, Apple> biFunction = Apple::new;
        Apple apple = biFunction.apply("Green",100L);
        System.out.println(apple);

        DefinedFunction<String, String, Long, ComplexApple> function = ComplexApple::new;
        ComplexApple app = function.apply("富士苹果","Red",360L);
        System.out.println(app);

        apples.sort(Comparator.comparing(Apple::getColor));
        System.out.println(apples);

    }

    private static <T> void useConsumer(Consumer<T> consumer,T t){
        consumer.accept(t);
    }
}
