package fu.day04.demo06;

import java.util.Scanner;

public class Anonymous {
    public static void main(String[] args) {

        //普通使用方式
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个数字");
        int num =sc.nextInt();
        System.out.println("输入的是："+num);

        //匿名对象使用方式
        System.out.println("请输入一个数字");
        int num1=new Scanner(System.in).nextInt();
        System.out.println("输入的是："+num1);

        //使用一般写法传入参数
        Scanner sca=new Scanner(System.in);
        methodParam(sca);

        //使用匿名对象来传参
        methodParam(new Scanner(System.in));
    }
    public static void methodParam(Scanner param){
        System.out.println("请输入一个数字");
        int num=param.nextInt();
        System.out.println("输入的是："+num);
    }
}
