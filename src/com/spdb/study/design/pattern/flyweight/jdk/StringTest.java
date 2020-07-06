package com.spdb.study.design.pattern.flyweight.jdk;

/**
 * JDK中String就应用了享元模式(共享常量池)
 * @author Mr.Longyx
 * @date 2020年07月06日 0:23
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "he"+"llo";

        String s4 = "hel"+new String("lo");
        String s5 = new String("hello");

        /**
         * 拿到s5内部的值对应的常量地址(缓存中取)
         * @author Mr.Longyx
         * @date 2020/7/6 0:33
         */
        String s6 = s5.intern();
        String s7 = "h";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//true
        System.out.println(s1 == s4);//false
        System.out.println(s1 == s5);//false
        System.out.println(s4 == s5);//false
        System.out.println(s1 == s6);//true
        System.out.println(s1 == s9);//false

    }
}
