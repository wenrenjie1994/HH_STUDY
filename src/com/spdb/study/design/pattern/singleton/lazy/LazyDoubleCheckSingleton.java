package com.spdb.study.design.pattern.singleton.lazy;

/**
 * 懒汉式单例(双重检查方式)
 * @author Mr.Longyx
 * @date 2020年06月22日 23:03
 */
public class LazyDoubleCheckSingleton {
    private static LazyDoubleCheckSingleton INSTANCE = null;
    /**
     * 构造方法私有化
     * @author Mr.Longyx
     * @date 2020/6/22 23:04
     */
    private LazyDoubleCheckSingleton(){}

    /**
     * 提供全局访问方法
     * 适中的方案
     * @author Mr.Longyx
     * @date 2020/6/22 23:05
     */
    public static LazyDoubleCheckSingleton getInstance() {
        if (null == INSTANCE){
            synchronized (LazyDoubleCheckSingleton.class){
                if (null == INSTANCE) {
                    /**
                     * 此处 CPU执行的时候会转换成JVM指令执行
                     * 指令重排序(volatile)
                     * 1、分配内存给这个对象
                     * 2、初始化对象
                     * 3、将初始化好的对象和内存地址建立联系
                     * 4、用户初次访问
                     */
                    INSTANCE = new LazyDoubleCheckSingleton();
                }

            }

        }
        return INSTANCE;
    }
}
