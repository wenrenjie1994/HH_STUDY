package com.liujinji.DesignPattern.Singleton;

// 单例模式-懒汉式，需要时再创建对象
public class BankSingletonLazy {
    // 私有化类的构造器
    private BankSingletonLazy() {
    }

    // 声明类的实例
    private static BankSingletonLazy instance = null;

    // 获取类的实例方法
    public static BankSingletonLazy getInstance() {
        // 如果实例从未被创建过，则创建当前类的实例
        if (instance == null) {
            instance = new BankSingletonLazy();
        }
        return instance;
    }
}
