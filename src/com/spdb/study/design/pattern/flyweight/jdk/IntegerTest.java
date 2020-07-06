package com.spdb.study.design.pattern.flyweight.jdk;

/**
 * JDK中Integer也应用到了享元模式
 * @author Mr.Longyx
 * @date 2020年07月06日 0:37
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(100);
        Integer b = 100;


        Integer c = Integer.valueOf(1000);
        Integer d = 1000;

        System.out.println(a == b);//true
        System.out.println(c == d); //false

    }
}
