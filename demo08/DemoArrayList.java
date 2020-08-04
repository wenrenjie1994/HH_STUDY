package fu.day04.demo08;
/*
数组的长度不可以阿生改变
但是ArrayList集合的长度是可以随意改变的
 对于ArrayList来说，有一个尖括号<E>代表泛型
 泛型，也就是装在集合当中的所有元素，全都是统一的什么类型
 注意：泛型只能是引用类型，不能是基本类型

 常用方法
 public boolean add
 */

import java.util.ArrayList;
import java.util.Random;

public class DemoArrayList {
    public static void main(String[] args) {
        //创建一个ArrayList集合，集合的名称是list，里面装的全都是String字符串类型的数据
        //备注，从Java1.7+开始，右侧的尖括号内可以不写东西
        ArrayList<String> list=new ArrayList<>();
        list.add("哈哈哈");
        list.add("嘻嘻嘻");
        System.out.println(list);

        //采用包装类，并遍历
        ArrayList<Integer> listInt=new ArrayList<>();
        listInt.add(1);
        listInt.add(100);
        listInt.add(1000);
        System.out.println(listInt);

        //遍历
        for (int i = 0; i < listInt.size(); i++) {
            System.out.println(listInt.get(i));
        }
        System.out.println("=====");

        //生成6个1~33之间的随机数，添加到集合，并遍历集合
        ArrayList<Integer> listRandom=new ArrayList<>();
        Random r=new Random();
        for (int i = 0; i < 6; i++) {
            int n=r.nextInt(33)+1;
            listRandom.add(n);
        }

        for (int i = 0; i < listRandom.size(); i++) {
            System.out.println(listRandom.get(i));
        }



    }
}
