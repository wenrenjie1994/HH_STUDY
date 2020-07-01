package com.spdb.study.design.pattern.singleton.lazy;

import java.lang.reflect.Constructor;

/**
 * 懒汉模式(静态内部类的方式)
 * @author Mr.Longyx
 * @date 2020年06月22日 23:27
 */
public class LazyInnerClassSingleton {
    /**
     * 构造方法私有化
     * 缺点：反射可达到攻击的目的
     * @author Mr.Longyx
     * @date 2020/6/22 23:28
     */
    private LazyInnerClassSingleton(){
        //此处防止反射攻击
        if (LazyHolder.INSTANCE != null){
            throw new RuntimeException("不允许构建多个实例");
        }
    }

    /**
     * 提供全局访问点
     * @author Mr.Longyx
     * @date 2020/6/22 23:28
     */
    private static LazyInnerClassSingleton getInstance() {
        return  LazyHolder.INSTANCE;
    }

    /**
     * LazyHolder里面的逻辑需要等到外部方法调用时才执行
     * 巧妙地利用内部类的特性
     * JVM底层执行逻辑，完美地避免了线程安全的问题
     * @author Mr.Longyx
     * @date 2020/6/22 23:29
     */
    private static class LazyHolder{
        private static final LazyInnerClassSingleton INSTANCE = new LazyInnerClassSingleton();
    }

    /**
     * 模拟内部类的反射攻击
     * 调用者不按约定的方法正确调用，使得单例被破坏
     * @author Mr.Longyx
     * @date 2020/6/22 23:39
     */
    public static void main(String[] args) {
        try {
            Class<?> clazz = LazyInnerClassSingleton.class;
            Constructor constructor = clazz.getDeclaredConstructor(null);

            //强制访问
            constructor.setAccessible(true);

            //动态创建对象
           Object obj =  clazz.newInstance();

           Object obj1 = LazyInnerClassSingleton.getInstance();

            System.out.println(obj == obj1);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
