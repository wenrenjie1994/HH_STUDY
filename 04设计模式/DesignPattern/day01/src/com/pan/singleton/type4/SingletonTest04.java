package com.pan.singleton.type4;

public class SingletonTest04 {
    public static void main(String[] args) {

        System.out.println("懒汉式2，线程安全的，但效率较低");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance == instance2);

    }

}

//懒汉式2（线程安全的,加同步锁）
class Singleton{
    private Singleton(){

    }

    private static Singleton instance;

    //提供一个静态的公有方法，加入同步处理的代码，解决线程安全的问题
    // 使用到该方法时，才去创建instance
    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
   return instance;
    }

}







