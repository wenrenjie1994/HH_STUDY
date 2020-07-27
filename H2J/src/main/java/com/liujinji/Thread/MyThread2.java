package com.liujinji.Thread;

/**
 * @author: liujinji0452@gmail.com
 * @time: 2020/7/27 09:51
 */
public class MyThread2 implements Runnable {
    private String name;

    public MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + ": " + i);
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
