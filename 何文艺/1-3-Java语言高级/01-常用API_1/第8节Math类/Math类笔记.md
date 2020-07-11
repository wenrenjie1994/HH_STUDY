**Math类笔记**  

----------


**一、数学工具类Math**  
java.util.Math类是与数学相关的工具类，里面提供了大量的静态方法【也就是说直接通过类名称调用就可以】，完成与数学运算相关的操作  

    1.public static double abs(double num)：获取绝对值，有多种重载  
    2.public static double ceil(double num)：向上取整（12.1取13 / 12.0取12.0）  
    3.public static double floor(double num)：向下取整（12.9取12 / 12.0取12.0）  
    4.public static long round(double num)：四舍五入（12.1取12 / 12.9取13）  
      
    Math.PI代表近似的圆周率  

**二、Math练习_小学数学真题**  
Demo02MathPractice.java  

    package demo;  
      
    /*  
    题目：计算在-10.8到5.9之间，绝对值大于6或者小于2.1的整数有多少个  
     */  
    public class Demo02MathPractice {  
        public static void main(String[] args) {  
            int count = 0;  
            for (double i = Math.ceil(-10.8) ; i < 5.9; i++) {  
                if(Math.abs(i) > 6 || Math.abs(i) < 2.1) {  
                    count++;  
                }  
            }  
            System.out.println(count);  
        }  
    }  