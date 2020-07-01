package cn.hwy.day0630.demo01;

/*
题目要求：定义一个方法，用来求出1-100之间所有数字的和
 */
public class Demo01MethodSum {
    public static void main(String[] args) {
        System.out.println(getSum());;
    }
    public static int getSum() {
        int sum = 0 ;
        for(int i = 1 ; i <= 100 ; i++) {
            sum += i;
        }
        return sum;
    }
}
