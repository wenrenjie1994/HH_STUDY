package com.spdb.study.java8.stream;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 13:00
 */
public class FirstStream {
    public static void main(String[] args) {
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

        //menu.stream().forEach(System.out::println);

        List<String> dishNames = getDishNamesByCollection(menu);
        System.out.println(dishNames);

        System.out.println(getDishNamesByStream(menu));

        List<String> result = menu.stream().filter(d->{
            System.out.println("filtering -> "+d.getName());
            return d.getCalories() > 300;
        }).map(d->{
            System.out.println("map -> "+d.getName());
            return d.getName();
        }).limit(3)
        .collect(toList());
        System.out.println(result);
    }

    private static List<String> getDishNamesByStream(List<Dish> menu) {
        //底层使用了ForkJoin
       return menu.parallelStream().filter(d->d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }

    private static List<String> getDishNamesByCollection(List<Dish> menu){
        List<Dish> lowCalories = new ArrayList<>();

        for (Dish dish : menu){
            if (dish.getCalories() < 400) {
                lowCalories.add(dish);
            }
        }
        Collections.sort(lowCalories, (b,a)->Integer.compare(a.getCalories(),b.getCalories()));
        List<String> dishNamesList = new ArrayList<> ();
        for (Dish dish : lowCalories){
            dishNamesList.add(dish.getName());
        }

        return dishNamesList;
    }
}
