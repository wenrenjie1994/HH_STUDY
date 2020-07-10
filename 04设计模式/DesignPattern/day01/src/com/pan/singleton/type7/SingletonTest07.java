package com.pan.singleton.type7;

public class SingletonTest07 {
    public static void main(String[] args) {

        System.out.println("使用静态内部类完成单例模式");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance == instance2);

    }

}

//静态内部类，推荐使用
class Singleton {
    //1.构造器私有化
    private Singleton() {
    }

    //2.写一个静态内部类，该类中有一个静态属性Singleton
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    private static volatile Singleton instance;

    //提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

}







