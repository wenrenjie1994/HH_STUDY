package com.liujinji.Commons;

public class SystemDemo {
    public static void main(String[] args) {
        System.currentTimeMillis();//时间戳
        System.exit(0);//终止当前正在运行的Java虚拟机
        System.gc();//运行垃圾回收
        System.getProperties();//获取系统全部属性
        System.getProperty("java.version");//获取系统某项属性
    }
}
