package com.spdb.study.java8.collector;

import com.spdb.study.java8.stream.Dish;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static com.spdb.study.java8.collector.CollectorsAction.menu;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author Mr.Longyx
 * @date 2020年07月08日 14:23
 */
public class CollectorsStreamPlus {
    public static void main(String[] args) {
        testSummaringDouble();
        testSummaringInt();
        testSummaringLong();
        testToCollect();
        testToConcurrentMap();
        testToConcurrentMapWithBinaryOperator();
        testToConcurrentMapWithBinaryOperatorAndSupplier();
        testToList();
        testToSet();
        testToMap();
        testToMapWithBinaryOperator();
        testToMapWithBinaryOperatorAndSupplier();
    }

    private static void testSummaringDouble(){
        DoubleSummaryStatistics collect = menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.of(collect).ifPresent(System.out::println);
    }

    private static void testSummaringInt(){
        int sum = menu.stream().map(Dish::getCalories).mapToInt(Integer::intValue).sum();
        Optional.ofNullable(sum).ifPresent(System.out::println);
    }

    private static void testSummaringLong(){
        Optional.ofNullable(menu.stream().collect(Collectors.summarizingLong(Dish::getCalories))).ifPresent(System.out::println);

        long sum = menu.stream().map(Dish::getCalories).mapToLong(d -> d.longValue()).sum();
        System.out.println(sum);
    }

    private static void testToCollect(){
        Optional.ofNullable(menu.stream().filter(d->d.getCalories() > 600).collect(Collectors.toCollection(LinkedList::new))).ifPresent(System.out::println);
    }

    private static void testToConcurrentMap(){
        Optional.ofNullable(menu.stream().collect(Collectors.toConcurrentMap(Dish::getName,Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void testToConcurrentMapWithBinaryOperator(){
        Optional.ofNullable(menu.stream().collect(Collectors.toConcurrentMap(Dish::getType,v->1,Integer::sum))).ifPresent(System.out::println);

    }

    private static void testToConcurrentMapWithBinaryOperatorAndSupplier(){
        Optional.of(menu.stream().collect(Collectors.toConcurrentMap(Dish::getType,v->1,(a,b)->a+b,ConcurrentSkipListMap::new))).ifPresent(System.out::println);
    }

    public static void testToList(){
        Optional.of(menu.stream().filter(Dish::isVegetarian).collect(toList())).ifPresent(System.out::println);
    }

    public static void testToSet(){
        Optional.of(menu.stream().filter(Dish::isVegetarian).collect(toSet())).ifPresent(System.out::println);
    }

    private static void testToMap(){
       Optional.of(menu.stream().filter(Dish::isVegetarian).collect(Collectors.toMap(Dish::getName,Dish::getCalories))).ifPresent(System.out::println);
   }

    private static void testToMapWithBinaryOperator(){
        Optional.ofNullable(menu.stream().collect(Collectors.toMap(Dish::getType,Dish::getCalories,BinaryOperator.maxBy(Integer::compareTo)))).ifPresent(System.out::println);
    }

    private static void testToMapWithBinaryOperatorAndSupplier(){
        Optional.of(menu.stream().collect(Collectors.toMap(Dish::getType,v->1,Integer::sum, Hashtable::new))).ifPresent(System.out::println);

        Optional.ofNullable(menu.stream().collect(Collectors.collectingAndThen(Collectors.toMap(Dish::getName, Dish::getCalories), Collections::synchronizedMap)))
                .ifPresent(v->{
                    System.out.println(v);
                    System.out.println(v.getClass());
                });
    }

}
