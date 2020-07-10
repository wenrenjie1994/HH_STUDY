package com.pan.java;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-15 17:19
 */
class Window3 implements Runnable{
    private int ticket = 100;//不用加static
    @Override
    public void run() {
        while (true){
            show();
            }
        }

        public synchronized void show(){//同步监视器：this
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"卖票：票号为："+ticket);
                ticket--;
            }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();


    }
}

