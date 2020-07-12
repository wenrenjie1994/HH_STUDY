package cn.sheng.day03;

/*
*       动态初始化数组时，数组元素会拥有一个默认的值
*       整数默认为               0
*       浮点数默认为             0.0
*       字符默认为               '\u0000'
*       布尔默认为               false
*       引用默认为               null
*
* */

public class Demo02ArrayUse {
    public static void main(String[] args) {
        int ArrayA[] = new int[3];
        System.out.println(ArrayA);//打印地址
        System.out.println(ArrayA[0]); //未初始化默认为0
        System.out.println(ArrayA[1]);
        System.out.println(ArrayA[2]);



    }
}
