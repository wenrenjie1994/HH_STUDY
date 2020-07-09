package com.spdb.study.java8.collector;

import com.spdb.study.java8.stream.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

import static com.spdb.study.java8.collector.CollectorsAction.menu;
/**
 * @author Mr.Longyx
 * @date 2020年07月08日 12:10
 */
public class CollectorsStream {
    public static void main(String[] args) {
        testGroupingByConcurrentHashMapWithFunction();
        testGroupingByConcurrentHashMapWithFunctionAndCollector();
        testGroupingByConcurrentHashMapWithFunctionAndSupplierAndCollector();
        testJoining();
        testJoiningWithDelimiter();
        testJoiningWithDelimiterAndPrefixAndSuffix();
        testMapping();
        testMaxBy();
        testMinBy();
    }

    private static void testGroupingByConcurrentHashMapWithFunction(){
        System.out.println("testGroupingByConcurrentHashMapWithFunction");

        ConcurrentMap<Dish.Type, List<Dish>> concurrentHashMap = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(concurrentHashMap.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(concurrentHashMap).ifPresent(System.out::println);
    }

    private static void testGroupingByConcurrentHashMapWithFunctionAndCollector(){
        System.out.println("testGroupingByConcurrentHashMapWithFunctionAndCollector");

        Optional.ofNullable(menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType,Collectors.averagingInt(Dish::getCalories)))).ifPresent(System.out::println);
    }

    private static void testGroupingByConcurrentHashMapWithFunctionAndSupplierAndCollector(){
        System.out.println("testGroupingByConcurrentHashMapWithFunctionAndCollector");

        ConcurrentSkipListMap<Dish.Type, Double> skipListMap = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType,ConcurrentSkipListMap::new, Collectors.averagingDouble(Dish::getCalories)));
        Optional.of(skipListMap.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(skipListMap).ifPresent(System.out::println);
    }

    private static void testJoining(){
        System.out.println("testJoining");
        Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining())).ifPresent(System.out::println);
    }

    private static void testJoiningWithDelimiter(){
        System.out.println("testJoiningWithDelimiter");
        Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining(" "))).ifPresent(System.out::println);
    }

    private static void testJoiningWithDelimiterAndPrefixAndSuffix(){
        System.out.println("testJoiningWithDelimiterAndPrefixAndSuffix");

        Optional.of(menu.stream().map(Dish::getName).collect(Collectors.joining(" ","Names[","]"))).ifPresent(System.out::println);
    }

    private static void testMapping(){
        System.out.println("testMapping");

        Optional.of(menu.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining(" ")))).ifPresent(System.out::println);
    }

    private static void testMaxBy(){
        System.out.println("testMaxBy");

        menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void testMinBy(){
        System.out.println("testMinBy");

        menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories))).ifPresent(System.out::println);
    }
}
