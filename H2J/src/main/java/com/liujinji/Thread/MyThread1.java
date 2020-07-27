package com.liujinji.Thread;

/**
 * @author: liujinji0452@gmail.com
 * @time: 2020/7/27 09:28
 */
class MyThread1 extends Thread {
    private String name;

    public MyThread1(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
