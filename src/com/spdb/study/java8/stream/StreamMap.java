package com.spdb.study.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 16:22
 */
public class StreamMap {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,2,5,6,8);
        List<Integer> result = list.stream().map(i->i * 2).collect(toList());
        System.out.println(result);

        listDish().stream().map(Dish::getName).forEach(System.out::println);

        List<String> dishes = listDish().stream().map(Dish::getName).collect(toList());
        System.out.println(dishes);

        String[] words = {"Hello","World"};
        //{'H','e','l','l','o'},{'W','o','r','l','d'}
        //Stream<String[]>
        Stream<String[]> stream = Arrays.stream(words).map(w->w.split(""));
        //'H','e','l','l','o','W','o','r','l','d'
        Stream<String> str = stream.flatMap(Arrays::stream);
        str.distinct().forEach(System.out::print);
    }

    private static List<Dish> listDish(){
        List<Dish> menu = Arrays.asList(
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
        return menu;
    }
}
