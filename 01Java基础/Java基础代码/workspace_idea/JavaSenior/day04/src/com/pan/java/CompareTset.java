package com.pan.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-18 13:29
 */
public class CompareTset {
    /*
    Comparable接口的使用举例：
     */
    @Test
    public void test1() {
        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenovo", 34);
        arr[1] = new Goods("dell", 43);
        arr[2] = new Goods("xiaomi", 12);
        arr[3] = new Goods("huawei", 65);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test3() {
        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr, new Comparator() {

            //按照字符串从大到小的定制排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);

                }
                throw new RuntimeException("输入数据类型错误！");
            }
        });
        System.out.println(Arrays.toString(arr));
    }


}
