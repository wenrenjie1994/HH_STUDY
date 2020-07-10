package com.pan.java;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-15 16:52
 */

/**
 * 例子：创建三个窗口卖票，总票数为100张，使用继承Thread类的方式
 * @author zhaopan@163.com
 * @creat 2020-04-15 9:56
 */
class Window2 extends Thread{
    //方式一：存在线程安全的问题
    //使用同步代码块解决线程安全问题
    private static int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (Window2.class) {//类也是对象，这个对象也是唯一的，只会加载一次
//            synchronized (obj) {//不能用this，this表示t1,t2,t3三个对象，锁就不唯一了
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "卖票：票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
}


public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

