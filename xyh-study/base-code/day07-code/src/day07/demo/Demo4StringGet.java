package day07.demo;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;

/*
String当中与获取相关的常用方法：
1.public int length():获取字符串当中含有的字符个数，即字符串长度
2.public String concat(String str):将当前字符串和参数中的字符串拼接成新的字符串并返回
3.public Char charAt(int index):获取指定索引位置的单个字符。
4.public int indexOf(String str):查找参数字符串在本字符串中首次出现的索引位置，如果没有返回-1
* */
public class Demo4StringGet {
    public static void main(String[] args) {
        //获取字符串你的长度
        String str="addffdfdfdfidfjlaifha";
        int len=str.length();
        System.out.println(len);
        //拼接字符串
        String str1="Hello";
        String str2="World";
        String str3=str1.concat(str2);
        System.out.println(str1);//Hello
        System.out.println(str2);//World
        System.out.println(str3);//新的字符串
        //获取指定索引位置的单个字符
        char ch="Hello".charAt(1);
        System.out.println(ch);

        //查找参数字符串在本来字符串当中出现的第一次索引位置
        String original="HelloWorld";
        int index=original.indexOf("ll");
        System.out.println(index);
    }
}
