package com.spdb.study.design.pattern.singleton.lazy;

import com.spdb.study.thread.ExecutorThread;

/**
 * 懒汉式单例(首次加载时不初始化，而是使用的时候才初始化)
 * @author Mr.Longyx
 * @date 2020年06月22日 21:38
 */
public class LazySingleton {
    private static LazySingleton INSTANCE = null;
    /**
     * 构造方法私有化
     * @author Mr.Longyx
     * @date 2020/6/22 21:39
     */
    private LazySingleton(){}

    /**
     * 提供全局访问的方法
     * synchronized  JDK 1.6之后对synchronized性能优化了不少
     * 但不可避免存在一定性能问题
     * @author Mr.Longyx
     * @date 2020/6/22 21:40
     */
    public static synchronized LazySingleton getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());
        t1.start();
        t2.start();

        System.out.println("Executor End!");
    }
}
