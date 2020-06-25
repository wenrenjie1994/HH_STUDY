package com.spdb.study.design.pattern.singleton.threadlocal;

/**
 * 注册式单例(容器式)
 * ThreadLocal:在线程内部是线程安全的  而跨线程则线程不安全
 * 伪线程安全
 * ThreadLocal可以实现多数据源的动态切换
 * @author Mr.Longyx
 * @date 2020年06月23日 15:26
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocal = ThreadLocal.withInitial(() -> new ThreadLocalSingleton());

    public static ThreadLocalSingleton getInstance(){
        return threadLocal.get();
    }

}
