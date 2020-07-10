package com.pan.facade;

public class Screen {
    private Screen() {
    }

    private static Screen instance = new Screen();

    public static Screen getInstance(){
        return instance;
    }

    public void up(){
        System.out.println("screen on");
    }

    public void down(){
        System.out.println("screen down");
    }
}
