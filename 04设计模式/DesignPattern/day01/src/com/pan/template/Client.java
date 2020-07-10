package com.pan.template;

public class Client {
    public static void main(String[] args) {
        //制作红豆豆浆
        System.out.println("-----制作红豆豆浆-------");
        SoyaMilk blackBeanSoyaMilk = new BlackBeanSoyaMilk();
        blackBeanSoyaMilk.make();

        System.out.println("-----制作花生豆浆-------");
        SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();
    }
}
