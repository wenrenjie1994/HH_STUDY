package com.pan.java;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-15 17:26
 */
class Window4 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    //    public synchronized void show(){//同步监视器：t1,t2,t3,此种方式是错误的
    public static synchronized void show() {//同步监视器：Window4.class,当前类
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票：票号为：" + ticket);
            ticket--;
        }
    }
}


public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

