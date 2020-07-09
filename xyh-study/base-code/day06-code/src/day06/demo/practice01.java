package day06.demo;

import java.util.ArrayList;
import java.util.Random;

/*
题目：生成6个1-33之间的随机数，添加到集合，并遍历集合
* */
public class practice01 {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(r.nextInt(33) + 1);

        }
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + i + "个数字是：" + list.get(i));
        }
    }
}
