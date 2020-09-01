package com.spdb.study.java8.collector;

import com.spdb.study.java8.stream.Dish;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static com.spdb.study.java8.collector.CollectorsAction.menu;
/**
 * @author Mr.Longyx
 * @date 2020年07月08日 13:13
 */
public class CollectorsStreamApp {
    public static void main(String[] args) {
        testPartitionByWithPredicate();
        testPartitioningByWithPredicateAndCollector();
        testReducingWithBinaryOperator();
        testReducingWithBinaryOperatorAndIdentity();
        testReducingWithBinaryOperatorAndIdentityAndFunction();
        testSummarizingDouble();
        testSummarizingInt();
        testSummarizingLong();
    }

    private static void testPartitionByWithPredicate(){
        System.out.println("testPartitionByWithPredicate");

        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.of(collect).ifPresent(System.out::println);
    }

    private static void testPartitioningByWithPredicateAndCollector(){
        System.out.println("testPartitioningByWithPredicateAndCollector");

        Optional<Map<Boolean, Double>> collect = Optional.ofNullable(menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.averagingInt(Dish::getCalories))));
        System.out.println(collect.get());
    }

    private static  void testReducingWithBinaryOperator(){
        System.out.println("testReducingWithBinaryOperator");

        Optional<Dish> collect = menu.stream().collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories))));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testReducingWithBinaryOperatorAndIdentity(){
        System.out.println("testReducingWithBinaryOperatorAndIdentity");

        Integer collect = menu.stream().map(Dish::getCalories).collect(Collectors.reducing(0, Integer::sum));
        System.out.println(collect);
    }

    private static void testReducingWithBinaryOperatorAndIdentityAndFunction(){
        System.out.println("testReducingWithBinaryOperatorAndIdentityAndFunction");

        Integer collect = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (a, b) -> a + b));
        System.out.println(collect);
    }

    private static void testSummarizingDouble(){
        System.out.println("testSummarizingDouble");

        DoubleSummaryStatistics collect = menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testSummarizingInt(){
        System.out.println("testSummarizingInt");

        Optional.ofNullable(menu.stream().collect(Collectors.summarizingInt(Dish::getCalories))).ifPresent(System.out::println);
    }
    private static void testSummarizingLong(){
        System.out.println("testSummarizingLong");

        Optional.ofNullable(menu.stream().collect(Collectors.summarizingLong(Dish::getCalories))).ifPresent(System.out::println);
    }
}
