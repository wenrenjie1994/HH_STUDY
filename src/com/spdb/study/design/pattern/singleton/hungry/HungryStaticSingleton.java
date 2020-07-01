package com.spdb.study.design.pattern.singleton.hungry;

/**
 * 饿汉式单例(static静态块方式)
 * @author Mr.Longyx
 * @date 2020年06月22日 21:31
 */
public class HungryStaticSingleton {
    /**
     * 静态块或静态字段都会在类加载时初始化
     * @author Mr.Longyx
     * @date 2020/6/22 21:34
     */
    private static final HungryStaticSingleton INSTANCE;

    static{
        INSTANCE = new HungryStaticSingleton();
    }
    /**
     * 构造函数私有化
     * @author Mr.Longyx
     * @date 2020/6/22 21:31
     */
    private HungryStaticSingleton(){}

    /**
     * 提供全局访问入口
     * @author Mr.Longyx
     * @date 2020/6/22 21:32
     */
    public static HungryStaticSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        HungryStaticSingleton singleton = HungryStaticSingleton.getInstance();
        HungryStaticSingleton singleton1 = HungryStaticSingleton.getInstance();

        System.out.println(singleton == singleton1);
    }
}
