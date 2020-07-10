package com.pan.facade;

public class DVDPlayer {
    //使用饿汉式
    private DVDPlayer() {
    }

    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("DVD on");
    }

    public void off(){
        System.out.println("DVD off");
    }
    public void play(){
        System.out.println("DVD is playing");
    }
    //...
    public void pause(){
        System.out.println("DVD pause");
    }
}
