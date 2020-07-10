package com.pan.facade;

public class Client {
    public static void main(String[] args) {
        //统一调用
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        System.out.println("------------");
        homeTheaterFacade.play();
        System.out.println("------------");
        homeTheaterFacade.pause();
        System.out.println("------------");
        homeTheaterFacade.end();

    }
}
