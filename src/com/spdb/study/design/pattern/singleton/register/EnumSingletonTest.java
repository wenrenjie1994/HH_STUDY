package com.spdb.study.design.pattern.singleton.register;

import java.lang.reflect.Constructor;

/**
 * @author Mr.Longyx
 * @date 2020年06月23日 15:01
 */
public class EnumSingletonTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = EnumSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(String.class,int.class);

            //强制访问
            c.setAccessible(true);
            EnumSingleton obj = (EnumSingleton)c.newInstance("Joe",666);
            System.out.println(obj);

            //从JDK层面就提供了枚举不被序列化和反射破坏的保证
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
