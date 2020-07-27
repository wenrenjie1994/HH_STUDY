package com.liujinji.Thread;


/**
 * @author: liujinji0452@gmail.com
 * @time: 2020/7/27 09:54
 */
public class MyThreadTest {
    public void ThreadTest() {
        MyThread1 myThreadA = new MyThread1("A");
        MyThread1 myThreadB = new MyThread1("B");
        myThreadA.start();
        myThreadB.start();
    }
    public void RunnableTest(){
        new Thread(new MyThread2("C")).start();
        new Thread(new MyThread2("D")).start();
    }

    public static void main(String[] args) {
        MyThreadTest svc = new MyThreadTest();
        svc.ThreadTest();
        svc.RunnableTest();
    }
}