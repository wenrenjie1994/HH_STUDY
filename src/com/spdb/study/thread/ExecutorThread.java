package com.spdb.study.thread;

import com.spdb.study.design.pattern.singleton.lazy.LazyDoubleCheckSingleton;
import com.spdb.study.design.pattern.singleton.lazy.LazySingleton;
import com.spdb.study.design.pattern.singleton.threadlocal.ThreadLocalSingleton;

/**
 * 用两个线程来模拟线程安全问题
 * @author Mr.Longyx
 * @date 2020年06月22日 22:30
 */
public class ExecutorThread implements Runnable{
    @Override
    public void run() {
  //      LazyDoubleCheckSingleton singleton = LazyDoubleCheckSingleton.getInstance();
 //       LazySingleton singleton = LazySingleton.getInstance();
        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() +" "+singleton);
        System.out.println(Thread.currentThread().getName() +" "+singleton);
        System.out.println(Thread.currentThread().getName() +" "+singleton);
        System.out.println(Thread.currentThread().getName() +" "+singleton);
    }
}
