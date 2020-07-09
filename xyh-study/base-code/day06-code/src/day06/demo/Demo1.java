package day06.demo;

import java.util.Random;

/*
  Random类用于生成随机数
  1.导包
  import java.util.Random;
  2.创建
  Random r=new Random();
  3.使用
  int num=r.nextInt();
  获取一个int型的随机数字（范围是int所有范围，有正负）
  int num=r.nextInt(3);[0,3),也就是0~2之间
  获取一个int型的随机数字（参数代表范围，左闭右开）

*/
public class Demo1 {

    public static void main(String[] args) {
        //int无范围
        Random r=new Random();
        int num1=r.nextInt();
        System.out.println("随机数是："+num1);

        //int有范围
        for (int i = 0; i <20 ; i++) {
            int num2 = r.nextInt(10);
            //输出范围在[0,10)
            System.out.println(num2);
        }

        //生成一个随机数，范围是[1,n]
        int n=5;
        System.out.println("===========================");
        for (int i1 = 0; i1 < 20; i1++) {
            //[0,n)+1 ->[1,n+1) ->[1,n]
            int result=r.nextInt(n)+1;
            System.out.println(result);

        }
    }
}


