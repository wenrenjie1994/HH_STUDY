package com.pan.singleton.type8;

public class SingletonTest08 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);

        instance.sayOK();
        instance2.sayOK();
    }
}

//使用枚举实现单例模式，推荐使用
enum Singleton{
    INSTANCE;
    public void sayOK(){
        System.out.println("OK~");
    }

}






