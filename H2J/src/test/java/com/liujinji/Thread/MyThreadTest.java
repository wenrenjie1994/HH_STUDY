package com.liujinji.Thread;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: liujinji0452@gmail.com
 * @time: 2020/7/27 09:54
 */
public class MyThreadTest {
    @Test
    public void ThreadTest() {
        MyThread1 myThreadA = new MyThread1("A");
        MyThread1 myThreadB = new MyThread1("B");
        myThreadA.start();
        myThreadB.start();
    }

}