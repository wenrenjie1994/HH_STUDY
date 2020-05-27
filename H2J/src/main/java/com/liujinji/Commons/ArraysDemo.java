package com.liujinji.Commons;

import java.util.Arrays;
import java.util.Random;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];
        // 将所有元素都填充成1
        Arrays.fill(arr,1);
        System.out.println(Arrays.toString(arr));

        Random random=new Random();
        for (int i = 0; i < arr.length; i++) {
            //使用100以内的随机数赋值数组
            arr[i] = random.nextInt(101);
        }
        // 将原数组内容copy到新的数组
        int[] newArr = Arrays.copyOf(arr, arr.length);

        // 内置排序方法
        Arrays.sort(arr);

        // 二分查找指定值对应的索引
        int i = Arrays.binarySearch(arr, 1);
        System.out.println("索引为"+i);
    }
}
