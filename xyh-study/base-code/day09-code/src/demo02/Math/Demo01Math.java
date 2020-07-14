package demo02.Math;
/*
java.util.Math类是数学相关的工具类，里面提供了大量的静态方法，完成与数学运算相关的操作
1.public static double abs(double num);获取绝对值（有多种重载）
2.public static double ceil(double num);向上取整
3.public static double floor(double num);向下取整
4.public static long round(double num);四舍五入
5.Math.PI代表近似的圆周率常亮
* */
public class Demo01Math {
    public static void main(String[] args) {
        //获取绝对值
        System.out.println(Math.abs(3.14));
        System.out.println(Math.abs(0));
        System.out.println(Math.abs(-2.5));
        System.out.println("=========================");
        //向上取整
        System.out.println(Math.ceil(3.9));//4.0
        System.out.println(Math.ceil(3.1));//4.0
        System.out.println(Math.ceil(3));//3.0
        System.out.println("=========================");

        //向下取整
        System.out.println(Math.floor(30.9));//30.0
        System.out.println(Math.floor(30.1));//30.0
        System.out.println(Math.floor(31.0));//30.0
        System.out.println("=========================");

        //四舍五入(没有小数点)
        System.out.println(Math.round(10.3));//10
        System.out.println(Math.round(10.1));//10
        System.out.println(Math.round(10.6));//11

        //圆周率(double值)
        System.out.println(Math.PI);
    }
}
