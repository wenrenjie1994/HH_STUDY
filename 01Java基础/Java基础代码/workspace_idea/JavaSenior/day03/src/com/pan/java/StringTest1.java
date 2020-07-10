package com.pan.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-17 9:14
 */
public class StringTest1 {

    @Test
    public void test4(){

    }



    @Test
    public void test3(){
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));

        String s = new String(bytes);
        System.out.println(s);
    }




    @Test
    public void test2(){
        String str1 = "abc123";
        char[] chars = str1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        String s = new String(chars);
        System.out.println(s);
    }




    @Test
    public void test1() {
        String str = "123";
        int num = Integer.parseInt(str);
        System.out.println(num);
//        System.out.println(str);
        String str1 = String.valueOf(num);
        System.out.println(str1);
        String str2 = num+"";
        System.out.println(str2);


    }

}
