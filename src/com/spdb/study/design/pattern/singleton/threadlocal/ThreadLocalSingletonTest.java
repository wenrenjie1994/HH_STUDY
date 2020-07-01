package com.spdb.study.design.pattern.singleton.threadlocal;

import com.spdb.study.thread.ExecutorThread;

/**
 * @author Mr.Longyx
 * @date 2020年06月23日 15:32
 */
public class ThreadLocalSingletonTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(ThreadLocalSingleton.getInstance());;

        new Thread(new ExecutorThread()).start();
        new Thread(new ExecutorThread()).start();

        System.out.println("Finish");

    }
}
