package com.liujinji.DesignPattern.Singleton;

// 单例模式-饿汉式，编译时先创建对象
public class BankSingletonHungry {
    // 私有化类的构造器
    private BankSingletonHungry() {
    }

    // 构造类对象
    private static BankSingletonHungry instance = new BankSingletonHungry();

    // 获取类对象的方法
    public static BankSingletonHungry getInstance() {
        return instance;
    }
}
