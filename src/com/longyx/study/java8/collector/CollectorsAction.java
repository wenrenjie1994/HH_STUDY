package com.spdb.study.java8.collector;

import com.spdb.study.java8.stream.Dish;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 对Collector中API的集中学习
 * @author Mr.Longyx
 * @date 2020年07月08日 10:34
 */
public class CollectorsAction {
        public static final List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

    public static void main(String[] args) {
        testAveragingDouble();
        testAveragingInt();
        testAveragingLong();
        testCollectingAndThen();
        testCounting();
        testGroupingByFunction();
        testGroupByFunctionAndCollector();
        testGroupByFunctionAndSupplierAndCollector();
        testSummarizingInt();
    }

    private static void testAveragingDouble(){
        System.out.println("testAveragingDouble");
        Optional.ofNullable(menu.stream().collect(Collectors.averagingDouble(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void testAveragingInt(){
        System.out.println("testAveragingInt");
        Optional.ofNullable(menu.stream().collect(Collectors.averagingInt(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void testAveragingLong(){
        System.out.println("testAveragingLong");
        Optional.ofNullable(menu.stream().collect(Collectors.averagingLong(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void testCollectingAndThen(){
        System.out.println("testCollectingAndThen");
        Optional.ofNullable(menu.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories),a->"The Average Calories is:"+a))).ifPresent(System.out::println);

//        List<Dish> dishes = menu.stream().filter(d->d.getType().equals(Dish.Type.MEAT)).collect(Collectors.collectingAndThen(toList(), Collections::unmodifiableList));
//        dishes.add(new Dish("",false, 150, Dish.Type.OTHER));
//        System.out.println(dishes);
    }

    private static void testCounting(){
        System.out.println("testCounting");
        Optional.of(menu.stream().collect(Collectors.counting())).ifPresent(System.out::println);
    }

    private static void testGroupingByFunction(){
        System.out.println("testGroupingByFunction");
        Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType))).ifPresent(System.out::println);
    }

    private static void testGroupByFunctionAndCollector(){
        System.out.println("testGroupByFunctionAndCollector");
        Optional.of(menu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.averagingInt(Dish::getCalories))))
                .ifPresent(System.out::println);
    }

    private static void testGroupByFunctionAndSupplierAndCollector(){
        System.out.println("testGroupByFunctionAndSupplierAndCollector");
        Map<Dish.Type,Double> map = menu.stream().collect(Collectors.groupingBy(Dish::getType,TreeMap::new, Collectors.averagingDouble(Dish::getCalories)));
        System.out.println(map.getClass());

        Optional.of(map).ifPresent(System.out::println);
    }

    private static void testSummarizingInt(){
        System.out.println("testSummarizingInt");
        IntSummaryStatistics summaryStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.of(summaryStatistics).ifPresent(System.out::println);
    }
}
