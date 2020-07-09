package day06.demo;
/*
题目：用一个大集合存入20个随机数，然后筛选其中的偶数元素，放到小集合当中。
要求使用自定义的方法来实现
* */

import java.util.ArrayList;
import java.util.Random;

public class practice04 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int j = 0; j < 20; j++) {
            list.add(r.nextInt(100));
        }
        ArrayList<Integer> result = selectEven(list);
        System.out.println(result);
    }

    public static ArrayList<Integer> selectEven(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num % 2 == 0) {
                result.add(num);
            }
        }
        return result;

    }
}
