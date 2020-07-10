package com.pan.singleton.type6;

public class SingletonTest06 {
    public static void main(String[] args) {

        System.out.println("双重检查，推荐使用");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance == instance2);

    }

}

//双重检查
class Singleton{
    private Singleton(){

    }

    private static volatile Singleton instance;

    //提供一个静态的公有方法，加入双重检查代码
    // 解决线程安全的问题，同时解决懒加载的问题
    // 同时保证了效率
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();

                }
            }
        }
   return instance;
    }

}







