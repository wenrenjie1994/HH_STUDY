package day07.demo;
/*
分割字符串的方法：
public String[] split(String regex):按照参数的规则，将字符串切分成若干部分
注：参数实际是正则表达式。
*/
public class Demo7StringSplit {
    public static void main(String[] args) {
        String str1="aaa bbb ccc ddd";
        String[] array1=str1.split(" ");
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
        System.out.println("=================");
        String str2="aaa.bbb.ccc.ddd";
        //"."在正则化表达式中有特殊含义。
        String[] array2=str2.split("\\.");
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
    }
}
