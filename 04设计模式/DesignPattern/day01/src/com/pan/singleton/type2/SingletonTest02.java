package com.pan.singleton.type2;

public class SingletonTest02 {
    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);

    }

}

//饿汉式（静态代码块）
class Singleton {
    //1.私有化构造器
    private Singleton() {

    }

    //2.内部创建对象实例
    private static Singleton instance;

    static {//在静态代码块中创建单例对象
        instance = new Singleton();
    }

    //3.提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

}




