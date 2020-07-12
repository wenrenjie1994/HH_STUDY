package day07.demo;
/*
String类
java.lang.String
程序中所有双引号字符串，都是String类的对象
字符串的特点：
1.字符串是常亮，内容不可变
2.字符串可以共享使用
3.字符串效果相当于char[]字符数组，但是底层原理是byte[]字节数组
创建字符串的常见3+1种方式
三种构造方法
public String():创建一个空白字符串，不含有任何内容
public String(char[] array):根据字符数组的内容，来创建对应的字符串
public String(byte[] array):根据字节数组的内容，来穿件对应的字符串
一种直接创建
String str="hello";
*/
public class Demo1String {
    public static void main(String[] args) {
        //创建空字符串
        String str1=new String();
        System.out.println("第一个字符串是："+str1);
        //根据字符数组创建字符串
        char[] charArray={'A','B','C'};
        String str2=new String(charArray);
        System.out.println("第二个字符串是："+str2);
        //根据字节数组创建字符串
        byte[] byteArray={97,98,99};
        String str3=new String(byteArray);
        System.out.println("第三个字符串是："+str3);
        //直接创建（不管new不new都是一个字符串对象）
        String str4="hello";
        System.out.println("第四个字符串是："+str4);




    }
}
