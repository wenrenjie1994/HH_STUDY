package com.longyx.study.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题引入
 * @author Mr.Longyx
 * @date 2020年07月06日 22:13
 */
public class FilterApple {

    @FunctionalInterface
    public interface AppleFilter{
        boolean filter(Apple apple);
    }

    public static List<Apple> findApple(List<Apple> apples, AppleFilter filter){
        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if (filter.filter(apple)){
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAnd150WeightFilter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("Green") && apple.getWeight()>=160);
        }
    }

    public static List<Apple> getGreenApple(List<Apple> apples){
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equalsIgnoreCase(apple.getColor())){
                list.add(apple);
            }
        }
        return list;
    }

    public static List<Apple> findApple(List<Apple> apples,String color){
        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples){
            if (color.equalsIgnoreCase(apple.getColor())){
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("Green",150L),new Apple("Red",360L),new Apple("Green",250L),new Apple("Yellow",420L));
        List<Apple> greenApples = getGreenApple(list);
        assert greenApples.size() == 2;

        List<Apple> redApple = findApple(list, "red");
        System.out.println(greenApples);
        System.out.println(redApple);

        List<Apple> result = findApple(list,new GreenAnd150WeightFilter());
        System.out.println(result);

        List<Apple> yellowApples = findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "Yellow".equalsIgnoreCase(apple.getColor());
            }
        });
        System.out.println(yellowApples);
    }
}
