package com.pan.java;

import org.junit.Test;

/**
 * @author zhaopan@163.com
 * @creat 2020-04-27 13:57
 */
public class ClassTest {

    //获取Class实例的方式
    @Test
    public void test1() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName(String classpath)（使用最频繁）
        Class clazz3 = Class.forName("com.pan.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz2 == clazz3);//true

        //方式四：使用类的加载器：ClassLoader(了解)
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.pan.java.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz4);//true


    }

}
