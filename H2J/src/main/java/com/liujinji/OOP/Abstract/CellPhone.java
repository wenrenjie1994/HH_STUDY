package com.liujinji.OOP.Abstract;

public class CellPhone extends Phone {
    @Override
    public void call() {
        System.out.println("calling...");
    }

    @Override
    public void message() {
        System.out.println("sending message...");
    }
}
