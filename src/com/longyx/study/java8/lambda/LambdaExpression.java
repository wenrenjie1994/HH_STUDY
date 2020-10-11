package com.longyx.study.java8.lambda;

import net.sf.cglib.core.internal.Function;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 23:52
 */
public class LambdaExpression {
    public static void main(String[] args) {
        Comparator<Apple> byColor = new Comparator<Apple> () {

            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> list = Collections.emptyList();
        list.sort(byColor);

        Comparator<Apple> comparator = Comparator.comparing(Apple::getColor);
        Comparator<Apple> comp = (o2,o1)->o1.getColor().compareTo(o2.getColor());
        System.out.println(comp.getClass());

        Function<String, Integer> sf = s->s.length();
        Predicate<Apple> apple = (Apple a)->a.getColor().equalsIgnoreCase("Green");

    }
}
