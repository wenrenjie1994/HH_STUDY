package cn.sheng.day02.demo03;

/*
方法重载（Overload）：方法名称相同仅参数列表不同(参数个数不同、参数类型不同)
                    返回类型不同不构成重载
*/


public class Demo01MethodOverload {
    public static void main(String[] args) {
        System.out.println(sum(10,5));
        System.out.println(sum(10,5,5));
        System.out.println(sum(10,5,5,5));
    }
    public static int sum(int a, int b) {
        return a + b;
    }
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }
    public static int sum(int a, int b,int c,int d) {
        return a + b + c + d;
    }


}
