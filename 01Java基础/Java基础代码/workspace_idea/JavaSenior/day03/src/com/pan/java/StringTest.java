package com.pan.java;

import org.junit.Test;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-16 15:07
 */
public class StringTest {
    @Test
    public void test1(){
        String s1 = "abc";
        String s2 = "abc";
//        s1 = "hello";

        System.out.println(s1 == s2);

        System.out.println(s1);
        System.out.println(s2);

    }
}
