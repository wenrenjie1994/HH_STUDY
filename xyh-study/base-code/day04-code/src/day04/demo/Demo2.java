package day04.demo;

import java.util.Scanner;
/*
练习：判断输入的三个数中的最大值
*/
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int a=sc.nextInt();
        System.out.println("请输入第二个数字");
        int b=sc.nextInt();
        System.out.println("请输入第三个数字");
        int c=sc.nextInt();
        int temp=a>b? a:b;
        int max=temp>c?temp:c;
        System.out.println("这三个数中最大的数是："+max);

    }
}
