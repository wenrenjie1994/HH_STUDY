package com.pan.singleton.type3;

public class SingletonTest03 {
    public static void main(String[] args) {

        System.out.println("懒汉式1，线程不安全的");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance == instance2);

    }

}

//懒汉式1（线程不安全的）
class Singleton{
    private Singleton(){

    }

    private static Singleton instance;

    //提供一个静态的公有方法，使用到该方法时，才去创建instance
    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
   return instance;
    }

}







