package day06.demo;

import java.util.ArrayList;

/*
题目：定义一个打印集合方法（用ArrayList类型作为对象），
使用{}扩起集合，使用@分隔每个元素
格式参照：{元素1@元素2@元素3}
*/
public class practice03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("lisa");
        list.add("Dora");
        list.add("Marry");
        list.add("Tommy");
        printArray(list);
        System.out.println();
        System.out.println(list);


    }

    public static void printArray(ArrayList<String> list) {
        int len = list.size();
        System.out.print("{");
        for (int i = 0; i < len; i++) {
            System.out.print(list.get(i) + "@");
            if (i == len - 1) {
                System.out.print(list.get(i));
            }
        }
        System.out.print("}");
    }
}
