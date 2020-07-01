package cn.hwy.day0630.demo01;

/*
题目要求：定义一个方法，用来打印指定次数的HelloWorld
 */
public class Demo01MethodPrint {
    public static void main(String[] args) {
        printString(10);
    }
    public static void printString(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("HelloWorld");
        }
    }
}
