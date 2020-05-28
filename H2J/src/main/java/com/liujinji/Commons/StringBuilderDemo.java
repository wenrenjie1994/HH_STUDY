package com.liujinji.Commons;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("am ");// 构造对象时可以初始字符
        sb.append("I "); //在末尾追加字符串
        sb.insert(0, "Who ");// 在指定索引添加
        int len = sb.length(); //获取sb对象长度
        sb.reverse(); // 反转字符串
        System.out.println(sb.toString());// 使用toString方法可以转为基本String类型
    }
}
