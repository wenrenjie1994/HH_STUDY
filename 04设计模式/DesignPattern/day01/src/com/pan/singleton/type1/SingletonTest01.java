package com.pan.singleton.type1;

public class SingletonTest01 {
    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance==instance2);

    }

}

//饿汉式（静态常量）
class Singleton{
    //1.私有化构造器
    private Singleton() {
    }

    //2.内部创建对象实例
    private final static Singleton instance =new  Singleton();

    //3.提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }

}




