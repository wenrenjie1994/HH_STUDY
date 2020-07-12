package day07.demo;

import jdk.swing.interop.SwingInterOpUtils;

/*
字符串的截取方法
public String substring(int index):截取从参数位置一直到字符末尾的字符串并返回
public String substring(int begin,int end):截取从begin开始，一直到end结束,返回被截取的字符串
注：[begin,end)
 */
public class Demo5SubString {
    public static void main(String[] args) {
        String str1="HelloWorld";
        String str2=str1.substring(5);
        System.out.println(str1);
        System.out.println(str2);
        String str3=str1.substring(4,7);
        System.out.println(str3);

        //以下这种情况字符串内容仍然没有改变
        //StrA中保存的是地址
        //本来地址是Hello的0x666
        //后来地址变成了JAVA的0x999
        String strA="Hello";
        System.out.println(strA);
        strA="JAVA";
        System.out.println(strA);
    }
}
