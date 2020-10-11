package com.longyx.study.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Predicate(boolean test(T t)、Consumer(void accept(T t))、Function(R apply(T t))、Supplier(T get())
 * @author Mr.Longyx
 * @date 2020年07月07日 0:22
 */
public class LambdaUsage {
    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple a : source){
            if (predicate.test(a)){
                result.add(a);
            }
        }
        return result;
    }

    private static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple a : source){
            if (predicate.test(a.getWeight())){
                result.add(a);
            }
        }
        return result;
    }

    private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Long> predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple a : source){
            if (predicate.test(a.getColor(),a.getWeight())){
                result.add(a);
            }
        }
        return result;
    }

    private static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumer){
        for (Apple a : source){
            consumer.accept(a);
        }
    }

    private static void testLongConsumer(List<Apple> apple, Consumer<Long> consumer){
        for (Apple a : apple) {
            consumer.accept(a.getWeight());
        }
    }

    private static void simpleTestBiConsumer(String c, List<Apple> source, BiConsumer<Apple,String> consumer){
        for (Apple a : source){
            consumer.accept(a,c);
        }
    }

    private static String testFunction(Apple apple, Function<Apple,String> fun){
        return fun.apply(apple);
    }

    private static Apple testBiFunction(String color, Long weight, BiFunction<String,Long,Apple> fun){
        return fun.apply(color,weight);
    }

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("hello");
        Runnable r = ()->{
            System.out.println("hello");
        };

        Runnable run = new Runnable() {

            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        process(runnable);
        process(r);
        process(run);
        process(()-> System.out.println("hello"));

        List<Apple> apples =  Arrays.asList(new Apple("Green",180L),new Apple("Red", 260L));
        List<Apple> greenApples = filter(apples,(apple)->apple.getColor().equalsIgnoreCase("Green"));
        System.out.println(greenApples);

        List<Apple> result = filterByWeight(apples,(w)->w > 100);
        System.out.println(result);

        List<Apple> rs = filterByBiPredicate(apples,(s,w)->s.equalsIgnoreCase("Green") && w > 100);
        System.out.println(rs);

        System.out.println("============================");
        simpleTestConsumer(apples,a-> System.out.println(a));

        System.out.println("============Long===================");
        testLongConsumer(apples,apple -> System.out.println(apple));

        simpleTestBiConsumer("XXX ",apples, (a,s)-> System.out.println(s + a.getColor()+ ":Weight=>"+a.getWeight()));

        String result3 = testFunction(new Apple("Yellow",100L),(a)->a.toString());
        System.out.println(result3);

        IntFunction<Double> f = i -> i*100.0d;
        double result4 = f.apply(10);
        System.out.println(result4);

        Apple ap = testBiFunction("cyan-blue",160L,(s,w)-> new Apple(s,w));
        System.out.println(ap);

        Supplier<String> supplier = String::new;
        System.out.println(supplier.get().getClass());

        Apple apple = createApple(()->new Apple("Green",120L));
        System.out.println(apple);

        /**
         * Lambda表达式中出现的变量默认是final类型的
         * 外部进行自加操作，内部就会报错
         * @author Mr.Longyx
         * @date 2020/7/7 10:08
         */
        int i =0;
        Runnable r3 = ()-> System.out.println(i);
//        i++;
        r3.run();
    }

    private static void process(Runnable r){
        r.run();
    }

    private static Apple createApple(Supplier<Apple> supplier){
        return supplier.get();
    }
}
