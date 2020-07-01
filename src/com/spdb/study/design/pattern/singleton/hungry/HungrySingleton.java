package com.spdb.study.design.pattern.singleton.hungry;

/**
 *  饿汉式单例
 *  构造方法私有化 提供一个全局访问的入口
 * @author Mr.Longyx
 * @date 2020年06月22日 21:22
 */
public class HungrySingleton {
    /**
     * 类加载时便初始化(static)
     * @author Mr.Longyx
     * @date 2020/6/22 21:30
     */
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton(){}

    /**
     * 提供一个全局访问点
     * @author Mr.Longyx
     * @date 2020/6/22 21:24
     */
    public static HungrySingleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        HungrySingleton singleton = HungrySingleton.getInstance();
        HungrySingleton singleton1 = HungrySingleton.getInstance();
        System.out.println(singleton == singleton1);
    }
}
