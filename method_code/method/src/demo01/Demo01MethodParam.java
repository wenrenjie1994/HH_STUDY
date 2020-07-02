package demo01;

import java.sql.SQLOutput;

/*
有参数：小括号有内容（需要一些数据条件才能执行）
无参数：
*/
public class Demo01MethodParam {
    public static void main(String[] args) {
        method1(30,40);
        method2();

    }
//    两个数字相乘
    public static void method1(int a,int b){
        int result =a*b;
        System.out.println("结果是："+ result);
    }
//    打印输出
    public static void method2(){
        for(int i=0;i<10;i++){
            System.out.println("Hello,world!"+i);
        }
    }
}
