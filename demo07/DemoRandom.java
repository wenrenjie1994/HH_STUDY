package fu.day04.demo07;
/*
random 类用来生成随机数字，
1.导包
import java.util.Random
2.创建
Random r=new Random();//小括号当中留空即可
3.使用
获取一个随机的int数字 (范围是int所有范围，有正负两种) int num=r.nextInt
获取一个随机的int数字（参数代表了范围，左闭右开区间）：int num=r.nextInt(3)
实际上代表的含义是：[0,3),也就是0~2
 */

import java.util.Random;

public class DemoRandom {
    public static void main(String[] args) {
        Random r=new Random();
        int num=r.nextInt();
        System.out.println("随机数是"+num);

        Random r1=new Random();
        int num1=r.nextInt(10);
        System.out.println("随机数是"+num1);
    }

}
