package com.pan.facade;

public class Popcorn {
    //使用饿汉式
    private Popcorn() {
    }

    private static Popcorn instance = new Popcorn();

    public static Popcorn getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("popcorn on");
    }

    public void off(){
        System.out.println("popcorn off");
    }
    public void pop(){
        System.out.println("popcorn is popping");
    }
    //...
//    public void pause(){
//        System.out.println("DVD pause");
//    }
}
