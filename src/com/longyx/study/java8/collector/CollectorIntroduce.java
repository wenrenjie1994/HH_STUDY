package com.longyx.study.java8.collector;

import com.longyx.study.java8.lambda.Apple;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 23:41
 */
public class CollectorIntroduce {
    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("Green", 150L),
                new Apple("Yellow",120L),
                new Apple("Green",250L),
                new Apple("Cyan-blue",240L),
                new Apple("Red", 180L)
        );
        List<Apple> greenApple = list.stream().filter(a -> a.getColor().equalsIgnoreCase("Green")).collect(toList());
        Optional.ofNullable(greenApple).ifPresent(System.out::println);

        Optional.ofNullable(groupByNormal(list)).ifPresent(System.out::println);
        Optional.ofNullable(groupByFunction(list)).ifPresent(System.out::println);
        Optional.ofNullable(groupByCollector(list)).ifPresent(System.out::println);
    }

    private static Map<String,List<Apple>> groupByNormal(List<Apple> apples){
        Map<String, List<Apple>> map = new HashMap<>();
        for (Apple apple : apples){
            List<Apple> list = map.get(apple.getColor());
            if (null == list){
                list = new ArrayList<>();
                map.put(apple.getColor(),list);
            }
            list.add(apple);
        }
        return map;
    }

    private static Map<String,List<Apple>> groupByFunction(List<Apple> apples){
        Map<String, List<Apple>> map = new HashMap<>();

        apples.stream().forEach(a ->{
            List<Apple> colorList = Optional.ofNullable(map.get(a.getColor())).orElseGet(()->{
                List<Apple> list = new ArrayList<>();
                map.put(a.getColor(),list);
                return list;
            });
            colorList.add(a);
        });
        return map;
    }

    private static Map<String, List<Apple>> groupByCollector(List<Apple> apples){
        return apples.stream().collect(Collectors.groupingBy(Apple::getColor));
    }
}
