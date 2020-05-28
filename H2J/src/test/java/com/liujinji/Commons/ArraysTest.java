package com.liujinji.Commons;

import org.junit.Test;

import java.util.Arrays;

public class ArraysTest {
    @Test
    public void searchNum() {
        int[] arr = {6, 17, 92, 32, 58, 22, 84, 66, 36, 33};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 对排序后的元素进行二分查找，如果没有排好序则不能找出对应元素索引
        int index = Arrays.binarySearch(arr, 33);
        System.out.println("元素33Index: " + index);

    }
}
